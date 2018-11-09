import axios from 'axios'
import ToolService from '@/api/com/pro/tool/toolService'
import Parameter from '@/api/com/pro/tool/Parameter'

const toolService = new ToolService()

const url = '/pro/sign/loginLog'

const vourl = '/pro/sign/loginLog/vo'

export default {
  save: (loginLog) => {
    let parameter = new Parameter()
    parameter.action = toolService.save
    return axios.post(url + toolService.getUrl(parameter), loginLog, toolService.getConfig())
  },
  batchSave: (loginLogOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchSave
    if (loginLogOrList instanceof Array) {
      return axios.post(url + toolService.getUrl(parameter), loginLogOrList, toolService.getConfig())
    } else {
      return axios.post(url + toolService.getUrl(parameter), new Array(loginLogOrList), toolService.getConfig())
    }
  },
  update: (loginLog) => {
    let parameter = new Parameter()
    parameter.action = toolService.update
    return axios.put(url + toolService.getUrl(parameter), loginLog, toolService.getConfig())
  },
  batchUpdate: (loginLogOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchUpdate
    if (loginLogOrList instanceof Array) {
      return axios.put(url + toolService.getUrl(parameter), loginLogOrList, toolService.getConfig())
    } else {
      return axios.put(url + toolService.getUrl(parameter), new Array(loginLogOrList), toolService.getConfig())
    }
  },
  remove: (loginLog) => {
    let parameter = new Parameter()
    parameter.action = toolService.remove
    return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(loginLog))
  },
  batchRemove: (loginLogOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchRemove
    if (loginLogOrList instanceof Array) {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(loginLogOrList))
    } else {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(new Array(loginLogOrList)))
    }
  },
  getByPk: (primaryKey) => {
    let parameter = new Parameter()
    parameter.action = toolService.getByPk
    parameter.primaryKey = primaryKey
    return axios.get(url + toolService.getUrl(parameter), toolService.getConfig())
  },
  getAll: () => {
    let parameter = new Parameter()
    parameter.action = toolService.getAll
    return axios.post(url + toolService.getUrl(parameter), toolService.getConfig())
  },
  paging: (rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.paging
    return axios.post(url + toolService.getPagingUrl(parameter, rows, page), toolService.getConfig())
  },
  query: (loginLogQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAll
    return axios.post(url + toolService.getUrl(parameter), loginLogQuery, toolService.getConfig())
  },
  pagingQuery: (loginLogQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.paging
    return axios.post(url + toolService.getPagingUrl(parameter, rows, page), loginLogQuery, toolService.getConfig())
  },
  getVOByPk: (primaryKey) => {
    let parameter = new Parameter()
    parameter.action = toolService.getVOByPk
    parameter.primaryKey = primaryKey
    return axios.get(url + toolService.getUrl(parameter), toolService.getConfig())
  },
  getAllVO: () => {
    let parameter = new Parameter()
    parameter.action = toolService.getAllVO
    return axios.post(vourl + toolService.getUrl(parameter), toolService.getConfig())
  },
  pagingVO: (rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.pagingVO
    return axios.post(vourl + toolService.getPagingUrl(parameter, rows, page), toolService.getConfig())
  },
  queryVO: (loginLogQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAllVO
    return axios.post(vourl + toolService.getUrl(parameter), loginLogQuery, toolService.getConfig())
  },
  pagingQueryVO: (loginLogQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.pagingVO
    return axios.post(vourl + toolService.getPagingUrl(parameter, rows, page), loginLogQuery, toolService.getConfig())
  }
}
