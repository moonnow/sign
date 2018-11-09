<style lang="less">
  @import './loginLog-detail.less';
</style>

<template>
  <div>
    <Card>
      <Button class="margin-bottom-12" @click="gotoList()">返回</Button>
      <Row>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>登录日志编号：{{ loginLog.logId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>账号编号：{{ loginLog.accountId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>账号：{{ loginLog.account }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>登录时间：{{ loginLog.loginTimes }}</p>
          <Divider dashed />
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import LoginLog from '@/view/com/pro/sign/loginLog/loginLog'

// @/view/com/pro/sign/loginLog/loginLog-detail/loginLog-detail.vue

export default {
  name: 'LoginLogDetail',
  props: {
  },
  data () {
    return {
      loginLog: new LoginLog()
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
      'getLoginLogByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'loginLog-list' })
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
