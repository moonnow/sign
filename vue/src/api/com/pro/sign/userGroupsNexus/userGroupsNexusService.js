import axios from 'axios'
import ToolService from '@/api/com/pro/tool/toolService'
import Parameter from '@/api/com/pro/tool/Parameter'

const toolService = new ToolService()

const url = '/pro/sign/userGroupsNexus'

const vourl = '/pro/sign/userGroupsNexus/vo'

export default {
  save: (userGroupsNexus) => {
    let parameter = new Parameter()
    parameter.action = toolService.save
    return axios.post(url + toolService.getUrl(parameter), userGroupsNexus, toolService.getConfig())
  },
  batchSave: (userGroupsNexusOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchSave
    if (userGroupsNexusOrList instanceof Array) {
      return axios.post(url + toolService.getUrl(parameter), userGroupsNexusOrList, toolService.getConfig())
    } else {
      return axios.post(url + toolService.getUrl(parameter), new Array(userGroupsNexusOrList), toolService.getConfig())
    }
  },
  update: (userGroupsNexus) => {
    let parameter = new Parameter()
    parameter.action = toolService.update
    return axios.put(url + toolService.getUrl(parameter), userGroupsNexus, toolService.getConfig())
  },
  batchUpdate: (userGroupsNexusOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchUpdate
    if (userGroupsNexusOrList instanceof Array) {
      return axios.put(url + toolService.getUrl(parameter), userGroupsNexusOrList, toolService.getConfig())
    } else {
      return axios.put(url + toolService.getUrl(parameter), new Array(userGroupsNexusOrList), toolService.getConfig())
    }
  },
  remove: (userGroupsNexus) => {
    let parameter = new Parameter()
    parameter.action = toolService.remove
    return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(userGroupsNexus))
  },
  batchRemove: (userGroupsNexusOrList) => {
    let parameter = new Parameter()
    parameter.action = toolService.batchRemove
    if (userGroupsNexusOrList instanceof Array) {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(userGroupsNexusOrList))
    } else {
      return axios.delete(url + toolService.getUrl(parameter), toolService.getConfig(new Array(userGroupsNexusOrList)))
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
  query: (userGroupsNexusQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAll
    return axios.post(url + toolService.getUrl(parameter), userGroupsNexusQuery, toolService.getConfig())
  },
  pagingQuery: (userGroupsNexusQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.paging
    return axios.post(url + toolService.getPagingUrl(parameter, rows, page), userGroupsNexusQuery, toolService.getConfig())
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
  queryVO: (userGroupsNexusQuery) => {
    let parameter = new Parameter()
    parameter.action = toolService.getAllVO
    return axios.post(vourl + toolService.getUrl(parameter), userGroupsNexusQuery, toolService.getConfig())
  },
  pagingQueryVO: (userGroupsNexusQuery, rows, page) => {
    let parameter = new Parameter()
    parameter.action = toolService.pagingVO
    return axios.post(vourl + toolService.getPagingUrl(parameter, rows, page), userGroupsNexusQuery, toolService.getConfig())
  }
}
