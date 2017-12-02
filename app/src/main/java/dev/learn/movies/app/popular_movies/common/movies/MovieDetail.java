package dev.learn.movies.app.popular_movies.common.movies;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import dev.learn.movies.app.popular_movies.common.Genre;

@SuppressWarnings("unused")
public class MovieDetail implements Parcelable {


    public static final Creator<MovieDetail> CREATOR = new Creator<MovieDetail>() {
        @Override
        public MovieDetail createFromParcel(Parcel in) {
            return new MovieDetail(in);
        }

        @Override
        public MovieDetail[] newArray(int size) {
            return new MovieDetail[size];
        }
    };
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("id")
    @Expose
    private long id;
    @SerializedName("overview")
    @Expose
    private String overview;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("release_date")
    @Expose
    private String releaseDate;
    @SerializedName("runtime")
    @Expose
    private long runtime;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tagline")
    @Expose
    private String tagline;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("vote_average")
    @Expose
    private double voteAverage;
    @SerializedName("vote_count")
    @Expose
    private long voteCount;
    @SerializedName("genres")
    @Expose
    private List<Genre> genres;
    @SerializedName("imdb_id")
    @Expose
    private String imdbId;
    @SerializedName("budget")
    @Expose
    private long budget;
    @SerializedName("revenue")
    @Expose
    private long revenue;

    private boolean isFavored = false;

    private boolean isBookmarked = false;

    public MovieDetail() {
    }

    protected MovieDetail(Parcel in) {
        backdropPath = in.readString();
        id = in.readLong();
        overview = in.readString();
        posterPath = in.readString();
        releaseDate = in.readString();
        runtime = in.readLong();
        status = in.readString();
        tagline = in.readString();
        title = in.readString();
        voteAverage = in.readDouble();
        voteCount = in.readLong();
        imdbId = in.readString();
        budget = in.readLong();
        revenue = in.readLong();
        isFavored = (in.readByte() != 0);
        isBookmarked = (in.readByte() != 0);
    }

    public String getBackdropPath() {
        return backdropPath;
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public long getRuntime() {
        return runtime;
    }

    public void setRuntime(long runtime) {
        this.runtime = runtime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(double voteAverage) {
        this.voteAverage = voteAverage;
    }

    public long getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(long voteCount) {
        this.voteCount = voteCount;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public String getImdbId() {
        return imdbId;
    }

    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public long getBudget() {
        return budget;
    }

    public void setBudget(long budget) {
        this.budget = budget;
    }

    public long getRevenue() {
        return revenue;
    }

    public void setRevenue(long revenue) {
        this.revenue = revenue;
    }

    public boolean isFavored() {
        return isFavored;
    }

    public void setFavored(boolean favored) {
        isFavored = favored;
    }

    public boolean isBookmarked() {
        return isBookmarked;
    }

    public void setBookmarked(boolean bookmarked) {
        isBookmarked = bookmarked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(backdropPath);
        parcel.writeLong(id);
        parcel.writeString(overview);
        parcel.writeString(posterPath);
        parcel.writeString(releaseDate);
        parcel.writeLong(runtime);
        parcel.writeString(status);
        parcel.writeString(tagline);
        parcel.writeString(title);
        parcel.writeDouble(voteAverage);
        parcel.writeLong(voteCount);
        parcel.writeString(imdbId);
        parcel.writeLong(budget);
        parcel.writeLong(revenue);
        parcel.writeByte((byte) (isFavored ? 1 : 0));
        parcel.writeByte((byte) (isBookmarked ? 1 : 0));
    }
}
