import axios from 'axios'
import ToolService from '@/api/com/pro/tool/toolService'
import Parameter from '@/api/com/pro/tool/Parameter'

const toolService = new ToolService()

const url = '/pro/sign/groups'

const vourl = '/pro/sign/groups/vo'

export default {
  save: (groups) => {
    let parameter = new Parameter()
    parameter.action = toolService.save
    return axios.post(url + toolService.getUrl(parameter), groups, toolService.getConfig())
  },
  batchSave: (groupsOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchSave
    if (groupsOrList instanceof Array) {
      return axios.post(url + toolService.getUrl(parameter), groupsOrList, toolService.getConfig())
    } else {
      return axios.post(url + toolService.getUrl(parameter), new Array(groupsOrList), toolService.getConfig())
    }
  },
  update: (groups) => {
    let parameter = new Parameter()
    parameter.action = toolService.update
    return axios.put(url + toolService.getUrl(parameter), groups, toolService.getConfig())
  },
  batchUpdate: (groupsOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchUpdate
    if (groupsOrList instanceof Array) {
      return axios.put(url + toolService.getUrl(parameter), groupsOrList, toolService.getConfig())
    } else {
      return axios.put(url + toolService.getUrl(parameter), new Array(groupsOrList), toolService.getConfig())
    }
  },
  remove: (groups) => {
    let parameter = new Parameter()
    parameter.action = toolService.remove
    return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(groups))
  },
  batchRemove: (groupsOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchRemove
    if (groupsOrList instanceof Array) {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(groupsOrList))
    } else {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(new Array(groupsOrList)))
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
  query: (groupsQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAll
    return axios.post(url + toolService.getUrl(parameter), groupsQuery, toolService.getConfig())
  },
  pagingQuery: (groupsQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.paging
    return axios.post(url + toolService.getPagingUrl(parameter, rows, page), groupsQuery, toolService.getConfig())
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
  queryVO: (groupsQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAllVO
    return axios.post(vourl + toolService.getUrl(parameter), groupsQuery, toolService.getConfig())
  },
  pagingQueryVO: (groupsQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.pagingVO
    return axios.post(vourl + toolService.getPagingUrl(parameter, rows, page), groupsQuery, toolService.getConfig())
  }
}
