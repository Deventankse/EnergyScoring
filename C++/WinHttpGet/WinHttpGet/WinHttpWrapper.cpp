// The MIT License (MIT)
// WinHTTP Wrapper 1.0.3
// Copyright (C) 2020 - 2022, by Wong Shao Voon (shaovoon@yahoo.com)
//
// http://opensource.org/licenses/MIT

// version 1.0.3: Set the text regardless the http status, not just for HTTP OK 200
// version 1.0.4: Add hGetHeaderDictionary() and contentLength to HttpResponse class
#include "WinHttpWrapper.h"
#include <winhttp.h>
#include "WinVersion.h"

#pragma comment(lib, "Winhttp.lib")
bool WinHttpWrapper::HttpRequest::Get(
	const std::wstring& rest_of_path,
	const std::wstring& requestHeader,
	HttpResponse& response)
{
	static const std::wstring verb = L"GET";
	static std::string body;
	return Request(
		verb,
		rest_of_path,
		requestHeader,
		body,
		response);
}

bool WinHttpWrapper::HttpRequest::Post(
	const std::wstring& rest_of_path,
	const std::wstring& requestHeader,
	const std::string& body,
	HttpResponse& response)
{
	static const std::wstring verb = L"POST";
	return Request(
		verb,
		rest_of_path,
		requestHeader,
		body,
		response);
}

bool WinHttpWrapper::HttpRequest::Put(
	const std::wstring& rest_of_path,
	const std::wstring& requestHeader,
	const std::string& body,
	HttpResponse& response)
{
	static const std::wstring verb = L"PUT";
	return Request(
		verb,
		rest_of_path,
		requestHeader,
		body,
		response);
}

