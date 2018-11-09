<style lang="less">
  @import './userGroupsNexus-edit.less';
</style>

<template>
  <div>
    <Card>
      <Form ref="userGroupsNexusForm" :model="userGroupsNexus" :rules="userGroupsNexusFormValidate" :label-width="120" class="margin-top-20">
        <Row type="flex" justify="center">
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="用户编号：" prop="userId">
              <Input v-model="userGroupsNexus.userId" placeholder="输入用户编号"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="组编号：" prop="groupsId">
              <Input v-model="userGroupsNexus.groupsId" placeholder="输入组编号"></Input>
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
import UserGroupsNexus from '@/view/com/pro/sign/userGroupsNexus/userGroupsNexus'

// @/view/com/pro/sign/userGroupsNexus/userGroupsNexus-edit/userGroupsNexus-edit.vue

export default {
  name: 'UserGroupsNexusEdit',
  props: {
  },
  data () {
    return {
      userGroupsNexus: new UserGroupsNexus(),
      userGroupsNexusFormValidate: {
        userId: [
          { required: true, message: '用户编号不能为空', trigger: 'blur' }
        ],
        groupsId: [
          { required: true, message: '组编号不能为空', trigger: 'blur' }
        ]
      },
      submitting: false,
      continue: null
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
      'saveUserGroupsNexus',
      'updateUserGroupsNexus',
      'getUserGroupsNexusByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'userGroupsNexus-list' })
    },
    reset () {
      this.$refs.userGroupsNexusForm.resetFields()
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
      this.$refs.userGroupsNexusForm.validate((valid) => {
        if (valid) {
          if (this.userGroupsNexus.nexusId !== 'add') {
            this.updateUserGroupsNexus(this.userGroupsNexus).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '数据库表信息修改成功.', duration: 3 })
                this.reset()
                this.userGroupsNexus = new UserGroupsNexus()
                this.userGroupsNexus.nexusId = 'add'
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
            this.saveUserGroupsNexus(this.userGroupsNexus).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '用户组关系信息保存成功.', duration: 3 })
                this.reset()
                this.userGroupsNexus = new UserGroupsNexus()
                this.userGroupsNexus.nexusId = 'add'
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
