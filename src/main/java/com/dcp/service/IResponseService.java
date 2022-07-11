
package com.dcp.service;

import java.util.List;

import com.dcp.entity.Response;

public interface IResponseService {

	public String addResponse(Response response);


	public Response editAnswer(int respId, String answer);

	public List<Response> likeResponse(int respId, int accuracy);

	public List<Response> deleteResponse(int respId);

	public List<Response> getResponseByDev(int respId);

}
