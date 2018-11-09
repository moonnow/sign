<style lang="less">
  @import './user-detail.less';
</style>

<template>
  <div>
    <Card>
      <Button class="margin-bottom-12" @click="gotoList()">返回</Button>
      <Row>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>用户编号：{{ user.userId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>用户标识：{{ user.userKey }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>用户名称：{{ user.userName }}</p>
          <Divider dashed />
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import User from '@/view/com/pro/sign/user/user'

// @/view/com/pro/sign/user/user-detail/user-detail.vue

export default {
  name: 'UserDetail',
  props: {
  },
  data () {
    return {
      user: new User()
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
      'getUserByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'user-list' })
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
