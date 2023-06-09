#include <stdio.h>
#include <stdlib.h>
#include <curl/curl.h>

int main(int argc, char *argv[])
{
  CURL *curl;
  char url[80];
  CURLcode res;

  strcpy(url,"http://bulksms.net/API.svc/sms/json/sendmessage?username=newuser&password=newpasswd&msg=test&msisdn=9999999999&tagname=Demo&shortcode=8888&telcoId=5&");

  curl = curl_easy_init();
  if(curl) {
    curl_easy_setopt(curl, CURLOPT_URL, url);
    curl_easy_setopt(curl, CURLOPT_POST, url);

    res = curl_easy_perform(curl);
    curl_easy_cleanup(curl);
  }
  return 0;
}