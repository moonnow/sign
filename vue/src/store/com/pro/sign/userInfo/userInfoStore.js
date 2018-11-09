import userInfoService from '@/api/com/pro/sign/userInfo/userInfoService'

// import userInfoStore from './com/pro/sign/userInfo/userInfoStore'

// store.registerModule('userInfoStore', userInfoStore)

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveUserInfo ({ commit, state }, userInfo) {
      return new Promise((resolve, reject) => {
        userInfoService.save(userInfo).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveUserInfo ({ commit, state }, userInfoOrList) {
      return new Promise((resolve, reject) => {
        userInfoService.batchSave(userInfoOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateUserInfo ({ commit, state }, userInfo) {
      return new Promise((resolve, reject) => {
        userInfoService.update(userInfo).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateUserInfo ({ commit, state }, userInfoOrList) {
      return new Promise((resolve, reject) => {
        userInfoService.batchUpdate(userInfoOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeUserInfo ({ commit, state }, userInfo) {
      return new Promise((resolve, reject) => {
        userInfoService.remove(userInfo).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveUserInfo ({ commit, state }, userInfoOrList) {
      return new Promise((resolve, reject) => {
        userInfoService.batchRemove(userInfoOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getUserInfoByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        userInfoService.getByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllUserInfo ({ commit, state }) {
      return new Promise((resolve, reject) => {
        userInfoService.getAll().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetUserInfo ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        userInfoService.paging(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryUserInfo ({ commit, state }, userInfoQuery) {
      return new Promise((resolve, reject) => {
        userInfoService.query(userInfoQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryUserInfo ({ commit, state }, { userInfoQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        userInfoService.pagingQuery(userInfoQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getUserInfoVOByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        userInfoService.getVOByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllUserInfoVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        userInfoService.getAllVO().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetUserInfoVO ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        userInfoService.pagingVO(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryUserInfoVO ({ commit, state }, userInfoQuery) {
      return new Promise((resolve, reject) => {
        userInfoService.queryVO(userInfoQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryUserInfoVO ({ commit, state }, { userInfoQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        userInfoService.pagingQueryVO(userInfoQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    }
  },
  getters: {
  }
}
