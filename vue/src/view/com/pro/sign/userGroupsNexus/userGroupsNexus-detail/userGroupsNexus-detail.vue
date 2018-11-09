<style lang="less">
  @import './userGroupsNexus-detail.less';
</style>

<template>
  <div>
    <Card>
      <Button class="margin-bottom-12" @click="gotoList()">返回</Button>
      <Row>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>用户组关系编号：{{ userGroupsNexus.nexusId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>用户编号：{{ userGroupsNexus.userId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>组编号：{{ userGroupsNexus.groupsId }}</p>
          <Divider dashed />
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import UserGroupsNexus from '@/view/com/pro/sign/userGroupsNexus/userGroupsNexus'

// @/view/com/pro/sign/userGroupsNexus/userGroupsNexus-detail/userGroupsNexus-detail.vue

export default {
  name: 'UserGroupsNexusDetail',
  props: {
  },
  data () {
    return {
      userGroupsNexus: new UserGroupsNexus()
    }
  },
  computed: {
    ...mapState('userGroupsNexusStore', [
    ]),
    ...mapGetters('userGroupsNexusStore', [
    ])
  },
  methods: {
    ...mapMutations('userGroupsNexusStore', [
    ]),
    ...mapActions('userGroupsNexusStore', [
      'getUserGroupsNexusByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'userGroupsNexus-list' })
    }
  },
  created () {
    this.userGroupsNexus.nexusId = this.$route.params.nexusId
    if (this.userGroupsNexus.nexusId !== 'add') {
      this.getUserGroupsNexusByPk(this.userGroupsNexus.nexusId).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          Object.assign(this.userGroupsNexus, res.data.data[0])
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
