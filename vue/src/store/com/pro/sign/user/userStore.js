import userService from '@/api/com/pro/sign/user/userService'

// import userStore from './com/pro/sign/user/userStore'

// store.registerModule('userStore', userStore)

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveUser ({ commit, state }, user) {
      return new Promise((resolve, reject) => {
        userService.save(user).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveUser ({ commit, state }, userOrList) {
      return new Promise((resolve, reject) => {
        userService.batchSave(userOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateUser ({ commit, state }, user) {
      return new Promise((resolve, reject) => {
        userService.update(user).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateUser ({ commit, state }, userOrList) {
      return new Promise((resolve, reject) => {
        userService.batchUpdate(userOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeUser ({ commit, state }, user) {
      return new Promise((resolve, reject) => {
        userService.remove(user).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveUser ({ commit, state }, userOrList) {
      return new Promise((resolve, reject) => {
        userService.batchRemove(userOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getUserByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        userService.getByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllUser ({ commit, state }) {
      return new Promise((resolve, reject) => {
        userService.getAll().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetUser ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        userService.paging(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryUser ({ commit, state }, userQuery) {
      return new Promise((resolve, reject) => {
        userService.query(userQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryUser ({ commit, state }, { userQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        userService.pagingQuery(userQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getUserVOByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        userService.getVOByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllUserVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        userService.getAllVO().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetUserVO ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        userService.pagingVO(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryUserVO ({ commit, state }, userQuery) {
      return new Promise((resolve, reject) => {
        userService.queryVO(userQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryUserVO ({ commit, state }, { userQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        userService.pagingQueryVO(userQuery, rows, page).then(res => {
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
