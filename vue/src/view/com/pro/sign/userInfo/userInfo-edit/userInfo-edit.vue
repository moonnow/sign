<style lang="less">
  @import './userInfo-edit.less';
</style>

<template>
  <div>
    <Card>
      <Form ref="userInfoForm" :model="userInfo" :rules="userInfoFormValidate" :label-width="120" class="margin-top-20">
        <Row type="flex" justify="center">
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="标签：" prop="labelName">
              <Input v-model="userInfo.labelName" placeholder="输入标签"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="内容：" prop="content">
              <Input v-model="userInfo.content" placeholder="输入内容"></Input>
            </FormItem>
          </Col>
          <Col :xs="24" :sm="20" :md="18" :lg="14">
            <FormItem label="用户编号：" prop="userId">
              <Input v-model="userInfo.userId" placeholder="输入用户编号"></Input>
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
import UserInfo from '@/view/com/pro/sign/userInfo/userInfo'

// @/view/com/pro/sign/userInfo/userInfo-edit/userInfo-edit.vue

export default {
  name: 'UserInfoEdit',
  props: {
  },
  data () {
    return {
      userInfo: new UserInfo(),
      userInfoFormValidate: {
        labelName: [
          { required: true, message: '标签不能为空', trigger: 'blur' }
        ],
        content: [
          { required: true, message: '内容不能为空', trigger: 'blur' }
        ],
        userId: [
          { required: true, message: '用户编号不能为空', trigger: 'blur' }
        ]
      },
      submitting: false,
      continue: null
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
      'saveUserInfo',
      'updateUserInfo',
      'getUserInfoByPk'
    ]),
    gotoList () {
      this.$router.push({ name: 'userInfo-list' })
    },
    reset () {
      this.$refs.userInfoForm.resetFields()
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
      this.$refs.userInfoForm.validate((valid) => {
        if (valid) {
          if (this.userInfo.userInfoId !== 'add') {
            this.updateUserInfo(this.userInfo).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '数据库表信息修改成功.', duration: 3 })
                this.reset()
                this.userInfo = new UserInfo()
                this.userInfo.userInfoId = 'add'
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
            this.saveUserInfo(this.userInfo).then(res => {
              if (res.data.isSuccess && res.data.statusCode === 200) {
                this.$Message.success({ content: '用户信息信息保存成功.', duration: 3 })
                this.reset()
                this.userInfo = new UserInfo()
                this.userInfo.userInfoId = 'add'
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
