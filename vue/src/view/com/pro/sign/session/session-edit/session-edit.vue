<style lang="less">
  @import './session-edit.less';
</style>

<template>
  <div>
    <Card>
      <Form ref="sessionForm" :model="session" :rules="sessionFormValidate" :label-width="120" class="margin-top-20">
        <Row type="flex" justify="center">
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="账号编号：" prop="accountId">
              <Input v-model="session.accountId" placeholder="输入账号编号"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="登录标识：" prop="loginKey">
              <Input v-model="session.loginKey" placeholder="输入登录标识"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="当前时间：" prop="currentTimes">
              <InputNumber v-model="session.currentTimes"></InputNumber>
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
import Session from '@/view/com/pro/sign/session/session'

// @/view/com/pro/sign/session/session-edit/session-edit.vue

export default {
  name: 'SessionEdit',
  props: {
  },
  data () {
    return {
      session: new Session(),
      sessionFormValidate: {
        accountId: [
          { required: true, message: '账号编号不能为空', trigger: 'blur' }
        ],
        loginKey: [
          { required: true, message: '登录标识不能为空', trigger: 'blur' }
        ],
        currentTimes: [
          { type: 'number', required: true, message: '当前时间不能为空', trigger: 'change' }
        ]
      },
      submitting: false,
      continue: null
    }
  },
  computed: {
    ...mapState('sessionStore', [
    ]),
    ...mapGetters('sessionStore', [
    ])
  },
  methods: {
    ...mapMutations('sessionStore', [
    ]),
    ...mapActions('sessionStore', [
      'saveSession',
      'updateSession',
      'getSessionByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'session-list' })
    },
    reset () {
      this.$refs.sessionForm.resetFields()
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
      this.$refs.sessionForm.validate((valid) => {
        if (valid) {
          if (this.session.sessionId !== 'add') {
            this.updateSession(this.session).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '数据库表信息修改成功.', duration: 3 })
                this.reset()
                this.session = new Session()
                this.session.sessionId = 'add'
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
            this.saveSession(this.session).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '会话信息保存成功.', duration: 3 })
                this.reset()
                this.session = new Session()
                this.session.sessionId = 'add'
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
    this.session.sessionId = this.$route.params.sessionId
    if (this.session.sessionId !== 'add') {
      this.getSessionByPk(this.session.sessionId).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          Object.assign(this.session, res.data.data[0])
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
