import axios from 'axios'
import ToolService from '@/api/com/pro/tool/toolService'
import Parameter from '@/api/com/pro/tool/Parameter'

const toolService = new ToolService()

const url = '/pro/sign/userInfo'

const vourl = '/pro/sign/userInfo/vo'

export default {
  save: (userInfo) => {
    let parameter = new Parameter()
    parameter.action = toolService.save
    return axios.post(url + toolService.getUrl(parameter), userInfo, toolService.getConfig())
  },
  batchSave: (userInfoOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchSave
    if (userInfoOrList instanceof Array) {
      return axios.post(url + toolService.getUrl(parameter), userInfoOrList, toolService.getConfig())
    } else {
      return axios.post(url + toolService.getUrl(parameter), new Array(userInfoOrList), toolService.getConfig())
    }
  },
  update: (userInfo) => {
    let parameter = new Parameter()
    parameter.action = toolService.update
    return axios.put(url + toolService.getUrl(parameter), userInfo, toolService.getConfig())
  },
  batchUpdate: (userInfoOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchUpdate
    if (userInfoOrList instanceof Array) {
      return axios.put(url + toolService.getUrl(parameter), userInfoOrList, toolService.getConfig())
    } else {
      return axios.put(url + toolService.getUrl(parameter), new Array(userInfoOrList), toolService.getConfig())
    }
  },
  remove: (userInfo) => {
    let parameter = new Parameter()
    parameter.action = toolService.remove
    return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(userInfo))
  },
  batchRemove: (userInfoOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchRemove
    if (userInfoOrList instanceof Array) {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(userInfoOrList))
    } else {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(new Array(userInfoOrList)))
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
  query: (userInfoQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAll
    return axios.post(url + toolService.getUrl(parameter), userInfoQuery, toolService.getConfig())
  },
  pagingQuery: (userInfoQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.paging
    return axios.post(url + toolService.getPagingUrl(parameter, rows, page), userInfoQuery, toolService.getConfig())
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
  queryVO: (userInfoQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAllVO
    return axios.post(vourl + toolService.getUrl(parameter), userInfoQuery, toolService.getConfig())
  },
  pagingQueryVO: (userInfoQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.pagingVO
    return axios.post(vourl + toolService.getPagingUrl(parameter, rows, page), userInfoQuery, toolService.getConfig())
  }
}
