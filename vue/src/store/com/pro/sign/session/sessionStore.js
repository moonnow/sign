import sessionService from '@/api/com/pro/sign/session/sessionService'

// import sessionStore from './com/pro/sign/session/sessionStore'

// store.registerModule('sessionStore', sessionStore)

export default {
  namespaced: true,
  state: {
  },
  mutations: {
  },
  actions: {
    saveSession ({ commit, state }, session) {
      return new Promise((resolve, reject) => {
        sessionService.save(session).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchSaveSession ({ commit, state }, sessionOrList) {
      return new Promise((resolve, reject) => {
        sessionService.batchSave(sessionOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    updateSession ({ commit, state }, session) {
      return new Promise((resolve, reject) => {
        sessionService.update(session).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchUpdateSession ({ commit, state }, sessionOrList) {
      return new Promise((resolve, reject) => {
        sessionService.batchUpdate(sessionOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    removeSession ({ commit, state }, session) {
      return new Promise((resolve, reject) => {
        sessionService.remove(session).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    batchRemoveSession ({ commit, state }, sessionOrList) {
      return new Promise((resolve, reject) => {
        sessionService.batchRemove(sessionOrList).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getSessionByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        sessionService.getByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllSession ({ commit, state }) {
      return new Promise((resolve, reject) => {
        sessionService.getAll().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetSession ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        sessionService.paging(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    querySession ({ commit, state }, sessionQuery) {
      return new Promise((resolve, reject) => {
        sessionService.query(sessionQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQuerySession ({ commit, state }, { sessionQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        sessionService.pagingQuery(sessionQuery, rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getSessionVOByPk ({ commit, state }, primaryKey) {
      return new Promise((resolve, reject) => {
        sessionService.getVOByPk(primaryKey).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    getAllSessionVO ({ commit, state }) {
      return new Promise((resolve, reject) => {
        sessionService.getAllVO().then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingGetSessionVO ({ commit, state }, { rows, page }) {
      return new Promise((resolve, reject) => {
        sessionService.pagingVO(rows, page).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    querySessionVO ({ commit, state }, sessionQuery) {
      return new Promise((resolve, reject) => {
        sessionService.queryVO(sessionQuery).then(res => {
          resolve(res)
        }).catch(err => {
          reject(err)
        })
      })
    },
    pagingQuerySessionVO ({ commit, state }, { sessionQuery, rows, page }) {
      return new Promise((resolve, reject) => {
        sessionService.pagingQueryVO(sessionQuery, rows, page).then(res => {
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
