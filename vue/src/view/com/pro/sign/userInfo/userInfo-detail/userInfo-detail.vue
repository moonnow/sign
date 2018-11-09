<style lang="less">
  @import './userInfo-detail.less';
</style>

<template>
  <div>
    <Card>
      <Button class="margin-bottom-12" @click="gotoList()">返回</Button>
      <Row>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>用户信息编号：{{ userInfo.userInfoId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>标签：{{ userInfo.labelName }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>内容：{{ userInfo.content }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>用户编号：{{ userInfo.userId }}</p>
          <Divider dashed />
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import UserInfo from '@/view/com/pro/sign/userInfo/userInfo'

// @/view/com/pro/sign/userInfo/userInfo-detail/userInfo-detail.vue

export default {
  name: 'UserInfoDetail',
  props: {
  },
  data () {
    return {
      userInfo: new UserInfo()
    }
  },
  computed: {
    ...mapState('userInfoStore', [
    ]),
    ...mapGetters('userInfoStore', [
    ])
  },
  methods: {
    ...mapMutations('userInfoStore', [
    ]),
    ...mapActions('userInfoStore', [
      'getUserInfoByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'userInfo-list' })
    }
  },
  created () {
    this.userInfo.userInfoId = this.$route.params.userInfoId
    if (this.userInfo.userInfoId !== 'add') {
      this.getUserInfoByPk(this.userInfo.userInfoId).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          Object.assign(this.userInfo, res.data.data[0])
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
