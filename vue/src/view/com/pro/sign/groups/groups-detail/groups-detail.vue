<style lang="less">
  @import './groups-detail.less';
</style>

<template>
  <div>
    <Card>
      <Button class="margin-bottom-12" @click="gotoList()">返回</Button>
      <Row>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>组编号：{{ groups.groupsId }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>组标识：{{ groups.groupsKey }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>组名称：{{ groups.groupsName }}</p>
          <Divider dashed />
        </Col>
        <Col :xs="24" :sm="12" :md="12" :lg="8">
          <p>描述：{{ groups.description }}</p>
          <Divider dashed />
        </Col>
      </Row>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import Groups from '@/view/com/pro/sign/groups/groups'

// @/view/com/pro/sign/groups/groups-detail/groups-detail.vue

export default {
  name: 'GroupsDetail',
  props: {
  },
  data () {
    return {
      groups: new Groups()
    }
  },
  computed: {
    ...mapState('groupsStore', [
    ]),
    ...mapGetters('groupsStore', [
    ])
  },
  methods: {
    ...mapMutations('groupsStore', [
    ]),
    ...mapActions('groupsStore', [
      'getGroupsByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'groups-list' })
    }
  },
  created () {
    this.groups.groupsId = this.$route.params.groupsId
    if (this.groups.groupsId !== 'add') {
      this.getGroupsByPk(this.groups.groupsId).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          Object.assign(this.groups, res.data.data[0])
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
