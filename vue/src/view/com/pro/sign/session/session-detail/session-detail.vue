<style lang="less">
  @import './session-detail.less';
</style>

<template>
  <div>
    <Card>
      <Button class="margin-bottom-12" @click="gotoList()">返回</Button>
      <Row>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>会话编号：{{ session.sessionId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>账号编号：{{ session.accountId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>登录标识：{{ session.loginKey }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>当前时间：{{ session.currentTimes }}</p>
          <Divider dashed />
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import Session from '@/view/com/pro/sign/session/session'

// @/view/com/pro/sign/session/session-detail/session-detail.vue

export default {
  name: 'SessionDetail',
  props: {
  },
  data () {
    return {
      session: new Session()
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
      'getSessionByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'session-list' })
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
