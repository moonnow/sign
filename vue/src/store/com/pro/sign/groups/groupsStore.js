import groupsService from '@/api/com/pro/sign/groups/groupsService'

// import groupsStore from './com/pro/sign/groups/groupsStore'

// store.registerModule('groupsStore', groupsStore)

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveGroups ({ commit, state }, groups) {
      return new Promise((resolve, reject) => {
        groupsService.save(groups).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveGroups ({ commit, state }, groupsOrList) {
      return new Promise((resolve, reject) => {
        groupsService.batchSave(groupsOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateGroups ({ commit, state }, groups) {
      return new Promise((resolve, reject) => {
        groupsService.update(groups).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateGroups ({ commit, state }, groupsOrList) {
      return new Promise((resolve, reject) => {
        groupsService.batchUpdate(groupsOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeGroups ({ commit, state }, groups) {
      return new Promise((resolve, reject) => {
        groupsService.remove(groups).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveGroups ({ commit, state }, groupsOrList) {
      return new Promise((resolve, reject) => {
        groupsService.batchRemove(groupsOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getGroupsByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        groupsService.getByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllGroups ({ commit, state }) {
      return new Promise((resolve, reject) => {
        groupsService.getAll().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetGroups ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        groupsService.paging(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryGroups ({ commit, state }, groupsQuery) {
      return new Promise((resolve, reject) => {
        groupsService.query(groupsQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryGroups ({ commit, state }, { groupsQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        groupsService.pagingQuery(groupsQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getGroupsVOByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        groupsService.getVOByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllGroupsVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        groupsService.getAllVO().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetGroupsVO ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        groupsService.pagingVO(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryGroupsVO ({ commit, state }, groupsQuery) {
      return new Promise((resolve, reject) => {
        groupsService.queryVO(groupsQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryGroupsVO ({ commit, state }, { groupsQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        groupsService.pagingQueryVO(groupsQuery, rows, page).then(res => {
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
