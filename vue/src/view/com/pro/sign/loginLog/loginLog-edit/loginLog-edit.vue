<style lang="less">
  @import './loginLog-edit.less';
</style>

<template>
  <div>
    <Card>
      <Form ref="loginLogForm" :model="loginLog" :rules="loginLogFormValidate" :label-width="120" class="margin-top-20">
        <Row type="flex" justify="center">
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="账号编号：" prop="accountId">
              <Input v-model="loginLog.accountId" placeholder="输入账号编号"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="账号：" prop="account">
              <Input v-model="loginLog.account" placeholder="输入账号"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="登录时间：" prop="loginTimes">
              <InputNumber v-model="loginLog.loginTimes"></InputNumber>
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
import LoginLog from '@/view/com/pro/sign/loginLog/loginLog'

// @/view/com/pro/sign/loginLog/loginLog-edit/loginLog-edit.vue

export default {
  name: 'LoginLogEdit',
  props: {
  },
  data () {
    return {
      loginLog: new LoginLog(),
      loginLogFormValidate: {
        accountId: [
          { required: true, message: '账号编号不能为空', trigger: 'blur' }
        ],
        account: [
          { required: true, message: '账号不能为空', trigger: 'blur' }
        ],
        loginTimes: [
          { type: 'number', required: true, message: '登录时间不能为空', trigger: 'change' }
        ]
      },
      submitting: false,
      continue: null
    }
  },
  computed: {
    ...mapState('loginLogStore', [
    ]),
    ...mapGetters('loginLogStore', [
    ])
  },
  methods: {
    ...mapMutations('loginLogStore', [
    ]),
    ...mapActions('loginLogStore', [
      'saveLoginLog',
      'updateLoginLog',
      'getLoginLogByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'loginLog-list' })
    },
    reset () {
      this.$refs.loginLogForm.resetFields()
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
      this.$refs.loginLogForm.validate((valid) => {
        if (valid) {
          if (this.loginLog.logId !== 'add') {
            this.updateLoginLog(this.loginLog).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '数据库表信息修改成功.', duration: 3 })
                this.reset()
                this.loginLog = new LoginLog()
                this.loginLog.logId = 'add'
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
            this.saveLoginLog(this.loginLog).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '登录日志信息保存成功.', duration: 3 })
                this.reset()
                this.loginLog = new LoginLog()
                this.loginLog.logId = 'add'
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
    this.loginLog.logId = this.$route.params.logId
    if (this.loginLog.logId !== 'add') {
      this.getLoginLogByPk(this.loginLog.logId).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          Object.assign(this.loginLog, res.data.data[0])
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
