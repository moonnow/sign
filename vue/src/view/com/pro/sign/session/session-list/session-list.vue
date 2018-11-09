<style lang="less">
  @import './session-list.less';
</style>

<template>
  <div>
    <Card>
      <Row>
        <Col :xs="12" :sm="10" :md="6" :lg="4">
          <Input search enter-button placeholder="关键字搜索" :disabled="keywordSearchSubmitting" @on-search="keywordSearch($event)" />
        </Col>
      </Row>
      <Collapse simple class="margin-top-10">
        <Panel>
          精准查询
          <div slot="content">
            <Form ref="sessionVagueQueryForm" :model="sessionVagueQuery" inline :label-width="135" class="margin-top-10">
              <FormItem label="账号编号：">
                <Input v-model="sessionVagueQuery.accountId" placeholder="输入账号编号"></Input>
              </FormItem>
              <FormItem label="登录标识：">
                <Input v-model="sessionVagueQuery.loginKey" placeholder="输入登录标识"></Input>
              </FormItem>
              <FormItem label="当前时间：">
                <InputNumber v-model="sessionVagueQuery.currentTimes"></InputNumber>
              </FormItem>
              <Button type="primary" @click="vagueQuery()" :loading="vagueQuerySubmitting">精准查询</Button>
            </Form>
          </div>
        </Panel>
      </Collapse>
      <Button class="pro-list-button" type="primary" ghost icon="ios-add-circle-outline" @click="add()">新建</Button>
      <Button class="pro-list-button" type="dashed" icon="ios-brush-outline" @click="up()" v-if="selectDataRowLength === 1">编辑</Button>
      <Poptip confirm title="确认删除？" placement="bottom" @on-ok="del()">
        <Button class="pro-list-button" type="error" ghost icon="ios-backspace-outline" v-if="selectDataRowLength > 0">删除</Button>
      </Poptip>
      <Button class="pro-list-button" icon="md-bulb" @click="detail()" v-if="selectDataRowLength === 1">详情</Button>
      <Table :columns="columns" :data="dataSet" @on-selection-change="setSelectDataRow($event)"></Table>
      <Row type="flex" justify="center" class="margin-top-10" v-if="pageShow">
        <Page :total="count" show-total show-sizer show-elevator :page-size-opts="[10, 30, 50]" @on-change="pageIndexChange($event)" @on-page-size-change="pageSizeChange($event)" />
      </Row>
      <Spin size="large" fix v-if="spinShow"></Spin>
    </Card>
  </div>
</template>

<script>
import { mapState, mapMutations, mapActions, mapGetters } from 'vuex'
import SessionQuery from '@/view/com/pro/sign/session/sessionQuery'

// @/view/com/pro/sign/session/session-list/session-list.vue

export default {
  name: 'SessionList',
  props: {
  },
  data () {
    return {
      columns: [
        { type: 'selection', width: 50, align: 'center', fixed: 'left' },
        { title: '账号编号', key: 'accountId', width: 200 },
        { title: '登录标识', key: 'loginKey', width: 200 },
        { title: '当前时间', key: 'currentTimes', width: 200 }
      ],
      dataSet: [],
      selectDataRow: [],
      selectDataRowLength: 0,
      spinShow: false,
      count: 0,
      rows: 10,
      page: 1,
      pageShow: true,
      keywordSearchClickRate: 0,
      keywordSearchSubmitting: false,
      vagueQuerySubmitting: false,
      sessionVagueQuery: new SessionQuery()
    }
  },
  computed: {
    ...mapState('sessionStore', [
    ]),
    ...mapGetters('sessionStore', [
    ])
  },
  methods: {
    ...mapMutations([
      'addTag'
    ]),
    ...mapMutations('sessionStore', [
    ]),
    ...mapActions('sessionStore', [
      'batchRemoveSession',
      'pagingGetSession',
      'querySession'
    ]),
    add () {
      const route = {
        name: 'session-edit',
        params: {
          sessionId: 'add'
        },
        meta: {
          icon: 'md-trending-up',
          title: '编辑会话'
        }
      }
      this.addTag({
        route: route,
        type: 'push'
      })
      this.$router.push(route)
    },
    up () {
      const route = {
        name: 'session-edit',
        params: {
          sessionId: this.selectDataRow[0].sessionId
        },
        meta: {
          title: '编辑会话'
        }
      }
      this.addTag({
        route: route,
        type: 'push'
      })
      this.$router.push(route)
    },
    detail () {
      const route = {
        name: 'session-detail',
        params: {
          sessionId: this.selectDataRow[0].sessionId
        },
        meta: {
          title: '会话详情'
        }
      }
      this.addTag({
        route: route,
        type: 'push'
      })
      this.$router.push(route)
    },
    setSelectDataRow (list) {
      this.selectDataRow = list
      this.selectDataRowLength = list.length
    },
    getDataSet () {
      this.spinShow = true
      this.pageShow = true
      this.pagingGetSession({ rows: this.rows, page: this.page }).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          this.dataSet = res.data.data
          this.count = res.data.count
          this.setSelectDataRow([])
          setTimeout(() => { this.spinShow = false }, 700)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.spinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: '请求失败！状态码 ' + result.response.status + ' ' + result.response.statusText, duration: 6 })
        setTimeout(() => { this.spinShow = false }, 700)
      })
    },
    del () {
      this.spinShow = true
      this.batchRemoveSession(this.selectDataRow).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          this.$Message.success({ content: '会话信息删除成功.', duration: 3 })
          this.setSelectDataRow([])
          this.getDataSet()
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.spinShow = false }, 700)
        }
      }).catch(result => {
        this.$Message.error({ content: '请求失败！状态码 ' + result.response.status + ' ' + result.response.statusText, duration: 6 })
        setTimeout(() => { this.spinShow = false }, 700)
      })
    },
    pageIndexChange (pageIndex) {
      this.page = pageIndex
      this.getDataSet()
    },
    pageSizeChange (pageSize) {
      this.rows = pageSize
      this.page = 1
      this.getDataSet()
    },
    keywordSearch (keyLikeValue) {
      if (keyLikeValue !== '') {
        this.keywordSearchSubmitting = true
        this.pageShow = false
        this.spinShow = true
        let sessionQueryKeyLikeValue = new SessionQuery()
        sessionQueryKeyLikeValue.accountIdAndKeyLike = '%' + keyLikeValue + '%'
        sessionQueryKeyLikeValue.loginKeyOrKeyLike = '%' + keyLikeValue + '%'
        this.querySession(sessionQueryKeyLikeValue).then(res => {
          if (res.data.isSuccess && res.data.statusCode === 200) {
            this.dataSet = res.data.data
            this.count = res.data.count
            this.setSelectDataRow([])
            setTimeout(() => { this.spinShow = false }, 700)
            setTimeout(() => { this.keywordSearchSubmitting = false }, 5000)
          } else {
            this.$Message.error({ content: res.data.msg, duration: 6 })
            setTimeout(() => { this.spinShow = false }, 700)
            setTimeout(() => { this.keywordSearchSubmitting = false }, 5000)
          }
        }).catch(result => {
          this.$Message.error({ content: '请求失败！状态码 ' + result.response.status + ' ' + result.response.statusText, duration: 6 })
          setTimeout(() => { this.spinShow = false }, 700)
          setTimeout(() => { this.keywordSearchSubmitting = false }, 5000)
        })
      } else {
        this.keywordSearchClickRate++
        if (this.keywordSearchClickRate > 10) {
          this.$Message.warning({ content: '兄dei，你是闲的吗？', duration: 6 })
          this.keywordSearchClickRate = 0
        }
      }
    },
    vagueQuery () {
      this.vagueQuerySubmitting = true
      this.pageShow = false
      this.spinShow = true
      this.querySession(this.sessionVagueQuery).then(res => {
        if (res.data.isSuccess && res.data.statusCode === 200) {
          this.dataSet = res.data.data
          this.count = res.data.count
          this.setSelectDataRow([])
          setTimeout(() => { this.spinShow = false }, 700)
          setTimeout(() => { this.vagueQuerySubmitting = false }, 5000)
        } else {
          this.$Message.error({ content: res.data.msg, duration: 6 })
          setTimeout(() => { this.spinShow = false }, 700)
          setTimeout(() => { this.vagueQuerySubmitting = false }, 5000)
        }
      }).catch(result => {
        this.$Message.error({ content: '请求失败！状态码 ' + result.response.status + ' ' + result.response.statusText, duration: 6 })
        setTimeout(() => { this.spinShow = false }, 700)
        setTimeout(() => { this.vagueQuerySubmitting = false }, 5000)
      })
    }
  },
  mounted () {
    this.getDataSet()
  }
}
</script>
