package org.hanbo.general.web.security;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hanbo.general.web.resources.ResourcesUtils;
import org.hanbo.general.web.security.models.UserModel;

@Service
public class LoginUserServiceImpl
   implements LoginUserService
{
   @Override
   public UserModel getLoginUser(String userName)
   {
      List<UserModel> allUserModels = loadAllAvailableUsers("/UserInfo.txt");
      
      UserModel retVal = null;
      if (!StringUtils.isEmpty(userName))
      {
         if (allUserModels != null && allUserModels.size() > 0)
         {
            for (UserModel userModel : allUserModels)
            {
               if (userName.equals(userModel.getUserName()))
               {
                  retVal = userModel;
               }
            }
         }
      }
      
      return retVal;
   }
   
   @SuppressWarnings("unchecked")
   private List<UserModel> loadAllAvailableUsers(String resourceName)
   {
      List<UserModel> retVal = new ArrayList<UserModel>();
      
      String userInfoAsText = ResourcesUtils.getResourceAsText(resourceName);
      if (!StringUtils.isEmpty(userInfoAsText))
      {
         Gson gson = new Gson();
         
         retVal = (ArrayList<UserModel>) gson.fromJson(userInfoAsText,
            new TypeToken<ArrayList<UserModel>>() {}.getType());
      }
      
      return retVal;
   }
}
