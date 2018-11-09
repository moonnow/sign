<style lang="less">
  @import './user-edit.less';
</style>

<template>
  <div>
    <Card>
      <Form ref="userForm" :model="user" :rules="userFormValidate" :label-width="120" class="margin-top-20">
        <Row type="flex" justify="center">
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="用户标识：" prop="userKey">
              <Input v-model="user.userKey" placeholder="输入用户标识"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="用户名称：" prop="userName">
              <Input v-model="user.userName" placeholder="输入用户名称"></Input>
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
import User from '@/view/com/pro/sign/user/user'

// @/view/com/pro/sign/user/user-edit/user-edit.vue

export default {
  name: 'UserEdit',
  props: {
  },
  data () {
    return {
      user: new User(),
      userFormValidate: {
        userKey: [
          { required: true, message: '用户标识不能为空', trigger: 'blur' }
        ],
        userName: [
          { required: true, message: '用户名称不能为空', trigger: 'blur' }
        ]
      },
      submitting: false,
      continue: null
    }
  },
  computed: {
    ...mapState('userStore', [
    ]),
    ...mapGetters('userStore', [
    ])
  },
  methods: {
    ...mapMutations('userStore', [
    ]),
    ...mapActions('userStore', [
      'saveUser',
      'updateUser',
      'getUserByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'user-list' })
    },
    reset () {
      this.$refs.userForm.resetFields()
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
      this.$refs.userForm.validate((valid) => {
        if (valid) {
          if (this.user.userId !== 'add') {
            this.updateUser(this.user).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '数据库表信息修改成功.', duration: 3 })
                this.reset()
                this.user = new User()
                this.user.userId = 'add'
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
            this.saveUser(this.user).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '用户信息保存成功.', duration: 3 })
                this.reset()
                this.user = new User()
                this.user.userId = 'add'
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
    this.user.userId = this.$route.params.userId
    if (this.user.userId !== 'add') {
      this.getUserByPk(this.user.userId).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          Object.assign(this.user, res.data.data[0])
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
