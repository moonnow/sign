import axios from 'axios'
import ToolService from '@/api/com/pro/tool/toolService'
import Parameter from '@/api/com/pro/tool/Parameter'

const toolService = new ToolService()

const url = '/pro/sign/user'

const vourl = '/pro/sign/user/vo'

export default {
  save: (user) => {
    let parameter = new Parameter()
    parameter.action = toolService.save
    return axios.post(url + toolService.getUrl(parameter), user, toolService.getConfig())
  },
  batchSave: (userOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchSave
    if (userOrList instanceof Array) {
      return axios.post(url + toolService.getUrl(parameter), userOrList, toolService.getConfig())
    } else {
      return axios.post(url + toolService.getUrl(parameter), new Array(userOrList), toolService.getConfig())
    }
  },
  update: (user) => {
    let parameter = new Parameter()
    parameter.action = toolService.update
    return axios.put(url + toolService.getUrl(parameter), user, toolService.getConfig())
  },
  batchUpdate: (userOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchUpdate
    if (userOrList instanceof Array) {
      return axios.put(url + toolService.getUrl(parameter), userOrList, toolService.getConfig())
    } else {
      return axios.put(url + toolService.getUrl(parameter), new Array(userOrList), toolService.getConfig())
    }
  },
  remove: (user) => {
    let parameter = new Parameter()
    parameter.action = toolService.remove
    return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(user))
  },
  batchRemove: (userOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchRemove
    if (userOrList instanceof Array) {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(userOrList))
    } else {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(new Array(userOrList)))
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
  query: (userQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAll
    return axios.post(url + toolService.getUrl(parameter), userQuery, toolService.getConfig())
  },
  pagingQuery: (userQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.paging
    return axios.post(url + toolService.getPagingUrl(parameter, rows, page), userQuery, toolService.getConfig())
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
  queryVO: (userQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAllVO
    return axios.post(vourl + toolService.getUrl(parameter), userQuery, toolService.getConfig())
  },
  pagingQueryVO: (userQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.pagingVO
    return axios.post(vourl + toolService.getPagingUrl(parameter, rows, page), userQuery, toolService.getConfig())
  }
}
