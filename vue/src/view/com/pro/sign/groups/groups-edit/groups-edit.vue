<style lang="less">
  @import './groups-edit.less';
</style>

<template>
  <div>
    <Card>
      <Form ref="groupsForm" :model="groups" :rules="groupsFormValidate" :label-width="120" class="margin-top-20">
        <Row type="flex" justify="center">
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="组标识：" prop="groupsKey">
              <Input v-model="groups.groupsKey" placeholder="输入组标识"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="组名称：" prop="groupsName">
              <Input v-model="groups.groupsName" placeholder="输入组名称"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="描述：" prop="description">
              <Input v-model="groups.description" placeholder="输入描述"></Input>
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
import Groups from '@/view/com/pro/sign/groups/groups'

// @/view/com/pro/sign/groups/groups-edit/groups-edit.vue

export default {
  name: 'GroupsEdit',
  props: {
  },
  data () {
    return {
      groups: new Groups(),
      groupsFormValidate: {
        groupsKey: [
          { required: true, message: '组标识不能为空', trigger: 'blur' }
        ],
        groupsName: [
          { required: true, message: '组名称不能为空', trigger: 'blur' }
        ]
      },
      submitting: false,
      continue: null
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
      'saveGroups',
      'updateGroups',
      'getGroupsByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'groups-list' })
    },
    reset () {
      this.$refs.groupsForm.resetFields()
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
      this.$refs.groupsForm.validate((valid) => {
        if (valid) {
          if (this.groups.groupsId !== 'add') {
            this.updateGroups(this.groups).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '数据库表信息修改成功.', duration: 3 })
                this.reset()
                this.groups = new Groups()
                this.groups.groupsId = 'add'
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
            this.saveGroups(this.groups).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '组信息保存成功.', duration: 3 })
                this.reset()
                this.groups = new Groups()
                this.groups.groupsId = 'add'
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
