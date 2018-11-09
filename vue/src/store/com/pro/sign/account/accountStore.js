import accountService from '@/api/com/pro/sign/account/accountService'

// import accountStore from './com/pro/sign/account/accountStore'

// store.registerModule('accountStore', accountStore)

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveAccount ({ commit, state }, account) {
      return new Promise((resolve, reject) => {
        accountService.save(account).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveAccount ({ commit, state }, accountOrList) {
      return new Promise((resolve, reject) => {
        accountService.batchSave(accountOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateAccount ({ commit, state }, account) {
      return new Promise((resolve, reject) => {
        accountService.update(account).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateAccount ({ commit, state }, accountOrList) {
      return new Promise((resolve, reject) => {
        accountService.batchUpdate(accountOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeAccount ({ commit, state }, account) {
      return new Promise((resolve, reject) => {
        accountService.remove(account).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveAccount ({ commit, state }, accountOrList) {
      return new Promise((resolve, reject) => {
        accountService.batchRemove(accountOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAccountByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        accountService.getByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllAccount ({ commit, state }) {
      return new Promise((resolve, reject) => {
        accountService.getAll().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetAccount ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        accountService.paging(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryAccount ({ commit, state }, accountQuery) {
      return new Promise((resolve, reject) => {
        accountService.query(accountQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryAccount ({ commit, state }, { accountQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        accountService.pagingQuery(accountQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAccountVOByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        accountService.getVOByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllAccountVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        accountService.getAllVO().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetAccountVO ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        accountService.pagingVO(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    queryAccountVO ({ commit, state }, accountQuery) {
      return new Promise((resolve, reject) => {
        accountService.queryVO(accountQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQueryAccountVO ({ commit, state }, { accountQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        accountService.pagingQueryVO(accountQuery, rows, page).then(res => {
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
