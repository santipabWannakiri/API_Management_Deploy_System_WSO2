package com.api.deploy.util;

import java.util.ArrayList;
import java.util.List;

import com.api.deploy.model.ApiDetailResponse;
import com.api.deploy.model.ApiListSubResponse;
import com.api.deploy.model.ApiListResponse;

public class UtilFunction {

	public List<ApiListSubResponse> ConvertToList(ApiListResponse response) {
		List<ApiListSubResponse> tempList = new ArrayList<>();
		for (int i = 0; i < response.getList().size(); i++) {
			tempList.add(response.getList().get(i));
		}
		return tempList;
	}

	public List<ApiDetailResponse> CompareAPISetStatus(List<ApiListSubResponse> tempListSource,
			List<ApiListSubResponse> tempListTarget) {
		List<ApiDetailResponse> resultlist = new ArrayList<>();

		for (int i = 0; i < tempListSource.size(); i++) {
			ApiDetailResponse tempList = new ApiDetailResponse();
			tempList.setId(tempListSource.get(i).getId());
			tempList.setName(tempListSource.get(i).getName());
			tempList.setDescription(tempListSource.get(i).getDescription());
			for (int x = 0; x < tempListTarget.size(); x++) {
				if (tempListSource.get(i).getName().equals(tempListTarget.get(x).getName())) {
					tempList.setStatus("deployed");
					tempList.setTargetApiID(tempListTarget.get(x).getId());
					break;
				} else
					tempList.setStatus("Not yet");
			}
			resultlist.add(tempList);
		}
		return resultlist;
	}

	public String IsNullandReplaceString(String str) {
		if (str == null) {
			return "null";
		} else {
			return str;
		}
	}
}
