package com.mujermorena ;
import com.mujermorena.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.search.*;
import java.sql.*;

public final  class GxFullTextSearchReindexer
{
   public static int Reindex( int remoteHandle )
   {
      GxSilentTrnSdt obj;
      IGxSilentTrn trn;
      boolean result;
      obj = new com.mujermorena.wwpbaseobjects.SdtWWP_Entity(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.mujermorena.wwpbaseobjects.SdtWWP_UserExtended(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.mujermorena.wwpbaseobjects.subscriptions.SdtWWP_Subscription(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.mujermorena.wwpbaseobjects.sms.SdtWWP_SMS(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebClient(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_NotificationDefinition(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.mujermorena.wwpbaseobjects.mail.SdtWWP_MailTemplate(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.mujermorena.wwpbaseobjects.notifications.web.SdtWWP_WebNotification(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.mujermorena.wwpbaseobjects.notifications.common.SdtWWP_Notification(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.mujermorena.wwpbaseobjects.SdtUserCustomizations(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      obj = new com.mujermorena.wwpbaseobjects.mail.SdtWWP_Mail(remoteHandle);
      trn = obj.getTransaction() ;
      result = trn.Reindex() ;
      return 1 ;
   }

}

