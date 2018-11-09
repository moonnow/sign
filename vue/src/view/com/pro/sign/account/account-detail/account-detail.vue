<style lang="less">
  @import './account-detail.less';
</style>

<template>
  <div>
    <Card>
      <Button class="margin-bottom-12" @click="gotoList()">返回</Button>
      <Row>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>账号编号：{{ account.accountId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>账号：{{ account.account }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>密码：{{ account.password }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>登录标识：{{ account.loginKey }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>权限标识：{{ account.permissionKey }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>用户编号：{{ account.userId }}</p>
          <Divider dashed />
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import Account from '@/view/com/pro/sign/account/account'

// @/view/com/pro/sign/account/account-detail/account-detail.vue

export default {
  name: 'AccountDetail',
  props: {
  },
  data () {
    return {
      account: new Account()
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
      'getAccountByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'account-list' })
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
