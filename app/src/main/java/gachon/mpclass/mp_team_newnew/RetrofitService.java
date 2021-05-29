package gachon.mpclass.mp_team_newnew;

import java.util.List;

import gachon.mpclass.mp_team_newnew.form.FileUploadResponse;
import gachon.mpclass.mp_team_newnew.form.MemberForm;
import gachon.mpclass.mp_team_newnew.form.PostingForm;
import gachon.mpclass.mp_team_newnew.form.TodaySaleForm;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RetrofitService {


    // @GET( EndPoint-자원위치(URI) )
    @GET("postings/postingList")// postings/postingList?email = email_string
    Call<List<PostingForm>> getPosts(@Query("email") String email);

    @GET("postings/postingList/country")
    Call<List<PostingForm>> getPostsByCountry(@Query("country") String country);

    @GET("postings/postingList/anniv")
    Call<List<PostingForm>> getPostsByAnniversary(@Query("anniv") String anniv);

    @POST("postings/new")
    Call<PostingForm> setPostBody(@Body PostingForm post, @Query("email") String email);





    @POST( "/members/new")
    Call<MemberForm> joinMember(@Body MemberForm member);

    @GET("/members/login")
    Call<Boolean> login(@Query("email") String email, @Query("pw") String pw);





    @POST("/todaysales/new")
    Call<TodaySaleForm> postTodaySale(@Body TodaySaleForm todaySaleForm);

    @GET("/todaysales")
    Call<List<TodaySaleForm>> getTodaySales();



    @Multipart
    @POST("/uploadFile")
    Call<FileUploadResponse> uploadFile(@Part MultipartBody.Part file);

    @GET("downloadFile//{fileName}")
    Call<ResponseBody> downloadFile(@Path("fileName") String imageName);
}
