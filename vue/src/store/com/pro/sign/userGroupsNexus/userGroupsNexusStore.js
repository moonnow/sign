import userGroupsNexusService from '@/api/com/pro/sign/userGroupsNexus/userGroupsNexusService'

// import userGroupsNexusStore from './com/pro/sign/userGroupsNexus/userGroupsNexusStore'

// store.registerModule('userGroupsNexusStore', userGroupsNexusStore)

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveUserGroupsNexus ({ commit, state }, userGroupsNexus) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.save(userGroupsNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveUserGroupsNexus ({ commit, state }, userGroupsNexusOrList) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.batchSave(userGroupsNexusOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateUserGroupsNexus ({ commit, state }, userGroupsNexus) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.update(userGroupsNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateUserGroupsNexus ({ commit, state }, userGroupsNexusOrList) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.batchUpdate(userGroupsNexusOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeUserGroupsNexus ({ commit, state }, userGroupsNexus) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.remove(userGroupsNexus).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveUserGroupsNexus ({ commit, state }, userGroupsNexusOrList) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.batchRemove(userGroupsNexusOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getUserGroupsNexusByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.getByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllUserGroupsNexus ({ commit, state }) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.getAll().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetUserGroupsNexus ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.paging(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryUserGroupsNexus ({ commit, state }, userGroupsNexusQuery) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.query(userGroupsNexusQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryUserGroupsNexus ({ commit, state }, { userGroupsNexusQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.pagingQuery(userGroupsNexusQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getUserGroupsNexusVOByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.getVOByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllUserGroupsNexusVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.getAllVO().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetUserGroupsNexusVO ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.pagingVO(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryUserGroupsNexusVO ({ commit, state }, userGroupsNexusQuery) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.queryVO(userGroupsNexusQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryUserGroupsNexusVO ({ commit, state }, { userGroupsNexusQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        userGroupsNexusService.pagingQueryVO(userGroupsNexusQuery, rows, page).then(res => {
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
