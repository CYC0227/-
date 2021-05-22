package gachon.mpclass.mp_team_newnew;

import gachon.mpclass.mp_team_newnew.form.MemberForm;
import gachon.mpclass.mp_team_newnew.form.PostingForm;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {


    // @GET( EndPoint-자원위치(URI) )
    @GET("posts/{post}")
    Call<PostingForm> getPosts(@Path("post") String post);

    @POST("postings/new")
    Call<PostingForm> setPostBody(@Body PostingForm post);

    @POST("members/new")
    Call<MemberForm> setMemberBody(@Body MemberForm member);
}
