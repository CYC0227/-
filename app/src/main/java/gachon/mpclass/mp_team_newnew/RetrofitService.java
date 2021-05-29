package gachon.mpclass.mp_team_newnew;

import java.util.List;

import gachon.mpclass.mp_team_newnew.form.MemberForm;
import gachon.mpclass.mp_team_newnew.form.PostingForm;
import gachon.mpclass.mp_team_newnew.form.TodaySaleForm;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
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

    @GET("/members/login")
    Call<List<TodaySaleForm>> getTodaySales();

}
