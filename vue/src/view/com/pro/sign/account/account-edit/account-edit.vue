<style lang="less">
  @import './account-edit.less';
</style>

<template>
  <div>
    <Card>
      <Form ref="accountForm" :model="account" :rules="accountFormValidate" :label-width="120" class="margin-top-20">
        <Row type="flex" justify="center">
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="账号：" prop="account">
              <Input v-model="account.account" placeholder="输入账号"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="密码：" prop="password">
              <Input v-model="account.password" placeholder="输入密码"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="登录标识：" prop="loginKey">
              <Input v-model="account.loginKey" placeholder="输入登录标识"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="权限标识：" prop="permissionKey">
              <Input v-model="account.permissionKey" placeholder="输入权限标识"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="用户编号：" prop="userId">
              <Input v-model="account.userId" placeholder="输入用户编号"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem>
              <Button class="margin-right-8" @click="gotoList()">取消</Button>
              <Button class="margin-right-8" @click="reset()">重置</Button>
              <Button class="margin-right-8" type="primary" @click="saveAdd()" :loading="submitting">保存并继续录入</Button>
              <Button class="margin-right-8" type="primary" @click="save()" :loading="submitting">保存</Button>
            </FormItem>
          </Col>
        </Row>
      </Form>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import Account from '@/view/com/pro/sign/account/account'

// @/view/com/pro/sign/account/account-edit/account-edit.vue

export default {
  name: 'AccountEdit',
  props: {
  },
  data () {
    return {
      account: new Account(),
      accountFormValidate: {
        account: [
          { required: true, message: '账号不能为空', trigger: 'blur' }
        ],
        password: [
          { required: true, message: '密码不能为空', trigger: 'blur' }
        ]
      },
      submitting: false,
      continue: null
    }
  },
  computed: {
    ...mapState('accountStore', [
    ]),
    ...mapGetters('accountStore', [
    ])
  },
  methods: {
    ...mapMutations('accountStore', [
    ]),
    ...mapActions('accountStore', [
      'saveAccount',
      'updateAccount',
      'getAccountByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'account-list' })
    },
    reset () {
      this.$refs.accountForm.resetFields()
    },
    saveAdd () {
      this.continue = true
      this.submit()
    },
    save () {
      this.continue = false
      this.submit()
    },
    submit () {
      this.submitting = true
      this.$refs.accountForm.validate((valid) => {
        if (valid) {
          if (this.account.accountId !== 'add') {
            this.updateAccount(this.account).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '数据库表信息修改成功.', duration: 3 })
                this.reset()
                this.account = new Account()
                this.account.accountId = 'add'
                this.submitting = false
                if (!this.continue) {
                  this.gotoList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                this.submitting = false
              }
            }).catch(result => {
              this.$Message.error({ content: '请求失败！状态码 ' + result.response.status + ' ' + result.response.statusText, duration: 6 })
              this.submitting = false
            })
          } else {
            this.saveAccount(this.account).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '账号信息保存成功.', duration: 3 })
                this.reset()
                this.account = new Account()
                this.account.accountId = 'add'
                this.submitting = false
                if (!this.continue) {
                  this.gotoList()
                }
              } else {
                this.$Message.error({ content: res.data.msg, duration: 6 })
                this.submitting = false
              }
            }).catch(result => {
              this.$Message.error({ content: '请求失败！状态码 ' + result.response.status + ' ' + result.response.statusText, duration: 6 })
              this.submitting = false
            })
          }
        } else {
          setTimeout(() => { this.submitting = false }, 3000)
        }
      })
    }
  },
  created () {
    this.account.accountId = this.$route.params.accountId
    if (this.account.accountId !== 'add') {
      this.getAccountByPk(this.account.accountId).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          Object.assign(this.account, res.data.data[0])
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
        }
      }).catch(result => {
        this.$Message.error({ content: '请求失败！状态码 ' + result.response.status + ' ' + result.response.statusText, duration: 6 })
      })
    }
  }
}
</script>
