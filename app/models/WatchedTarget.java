package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Page;
import com.avaje.ebean.RawSql;
import com.avaje.ebean.RawSqlBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;

import play.db.ebean.Model;

@Entity
public class WatchedTarget extends Model {
	@Id
	public Long id;
	@OneToOne @JsonIgnore
	@JoinColumn(name="id_target")
	public Target target;
	@ManyToOne @JsonIgnore
	@JoinColumn(name="id_creator")
	public User user;
	@OneToMany(mappedBy="watchedTarget", cascade=CascadeType.REMOVE) @JsonIgnore
	public List<Document> documents;
    @OneToMany(mappedBy="watchedTarget", cascade=CascadeType.REMOVE) @JsonIgnore
    public List<JournalTitle> journalTitles = new ArrayList<>();
	public String documentUrlScheme;
	public String getUrl() { return ""+id; }
	public String getName() { return target.field_url; }
	public static final String SEARCH_FIELD = "target.field_url";
	//@Transient
	//public int documentCount;
	
	public static final Model.Finder<Long, WatchedTarget> find = new Model.Finder<>(Long.class, WatchedTarget.class);
	
	public WatchedTarget(User user, String title, String url, String field_url, String documentUrlScheme) {
		this.user = user;
		this.documentUrlScheme = documentUrlScheme;
		target = new Target(title, url);
		target.field_url = field_url;
		target.active = true;
		target.author = user.url;
	}
	
    public WatchedTarget(Target target, String documentUrlScheme) {
		this.target = target;
		user = User.findByUrl(target.author);
		this.documentUrlScheme = documentUrlScheme;
	}
	public static Page<WatchedTarget> page(Long userId, int page, int pageSize, String sortBy, String order, String filter) {
		
		ExpressionList<WatchedTarget> el = find.where();
		
		if (userId != null)
    		el = el.eq("id_creator", userId);
		
        return el.icontains(SEARCH_FIELD, filter)
        		.orderBy(sortBy + " " + order)
        		.findPagingList(pageSize)
        		.setFetchAhead(false)
        		.getPage(page);
    }
}
