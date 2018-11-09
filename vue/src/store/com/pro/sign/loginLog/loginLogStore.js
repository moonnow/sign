import loginLogService from '@/api/com/pro/sign/loginLog/loginLogService'

// import loginLogStore from './com/pro/sign/loginLog/loginLogStore'

// store.registerModule('loginLogStore', loginLogStore)

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveLoginLog ({ commit, state }, loginLog) {
      return new Promise((resolve, reject) => {
        loginLogService.save(loginLog).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveLoginLog ({ commit, state }, loginLogOrList) {
      return new Promise((resolve, reject) => {
        loginLogService.batchSave(loginLogOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateLoginLog ({ commit, state }, loginLog) {
      return new Promise((resolve, reject) => {
        loginLogService.update(loginLog).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateLoginLog ({ commit, state }, loginLogOrList) {
      return new Promise((resolve, reject) => {
        loginLogService.batchUpdate(loginLogOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeLoginLog ({ commit, state }, loginLog) {
      return new Promise((resolve, reject) => {
        loginLogService.remove(loginLog).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveLoginLog ({ commit, state }, loginLogOrList) {
      return new Promise((resolve, reject) => {
        loginLogService.batchRemove(loginLogOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getLoginLogByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        loginLogService.getByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllLoginLog ({ commit, state }) {
      return new Promise((resolve, reject) => {
        loginLogService.getAll().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetLoginLog ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        loginLogService.paging(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryLoginLog ({ commit, state }, loginLogQuery) {
      return new Promise((resolve, reject) => {
        loginLogService.query(loginLogQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryLoginLog ({ commit, state }, { loginLogQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        loginLogService.pagingQuery(loginLogQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getLoginLogVOByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        loginLogService.getVOByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllLoginLogVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        loginLogService.getAllVO().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetLoginLogVO ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        loginLogService.pagingVO(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryLoginLogVO ({ commit, state }, loginLogQuery) {
      return new Promise((resolve, reject) => {
        loginLogService.queryVO(loginLogQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryLoginLogVO ({ commit, state }, { loginLogQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        loginLogService.pagingQueryVO(loginLogQuery, rows, page).then(res => {
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
