package models;

import java.lang.reflect.Field;
import java.util.*;

import javax.persistence.*;

import com.avaje.ebean.ExpressionList;

import play.Logger;
import play.db.ebean.*;
import uk.bl.Const;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * DCollection entity managed by Ebean
 */
@SuppressWarnings("serial")
@Entity 
public class DCollection extends Model {

    @Id @JsonIgnore
    public Long nid;
    @Column(columnDefinition = "TEXT") @JsonIgnore
    public String value;
    @Column(columnDefinition = "TEXT") @JsonIgnore
    public String summary; 
    @JsonIgnore
    public String format;
    @JsonIgnore
    public Long vid;
    @JsonIgnore
    public Boolean is_new;
    @JsonIgnore
    public String type;
    public String title;
    @JsonIgnore
    public String language;
    public String url;
    @JsonIgnore
    public String edit_url;
    @JsonIgnore
    public Long status;
    @JsonIgnore
    public Long promote;
    @JsonIgnore
    public Long sticky;
    @JsonIgnore
    public String created;
    @JsonIgnore
    public String changed;
    @JsonIgnore
    public String author;
    @JsonIgnore
    public String log;
    @JsonIgnore
    public Long comment;
    @JsonIgnore
    public Long comment_count;
    @JsonIgnore
    public Long comment_count_new;
    // TODO difference between XML and JSON
    @JsonIgnore
    public String revision;
    @JsonIgnore
    public Long feed_nid;    
    // lists
    @Column(columnDefinition = "TEXT") @JsonIgnore
    public String field_targets; 
    @Column(columnDefinition = "TEXT") @JsonIgnore
    public String field_sub_collections; 
    @Column(columnDefinition = "TEXT") @JsonIgnore
    public String field_instances; 
    // additional fields from taxonomy
    @JsonIgnore
    public Long weight;
    @JsonIgnore
    public Long node_count;
    @Column(columnDefinition = "TEXT") @JsonIgnore
    public String vocabulary;
    // lists
    @Column(columnDefinition = "TEXT")  @JsonIgnore
    public String parent;
    @Column(columnDefinition = "TEXT")  @JsonIgnore
    public String parents_all;


    /**
     * Constructor
     * @param title
     */
    public DCollection(String title) {
        this.title = title;
    }

    public DCollection() {
    }
    
    // -- Queries
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Model.Finder<Long,DCollection> find = new Model.Finder(Long.class, DCollection.class);
    
    /**
     * Retrieve dcollections 
     */
    public static List<DCollection> findInvolving() {
        return find.all();
    }
    
    /**
     * Retrieve all collections.
     */
    public static List<DCollection> findAll() {
        return find.all();
    }
    
    /**
     * Create a new dcollection.
     */
    public static DCollection create(String title) {
        DCollection dcollection = new DCollection(title);
        dcollection.save();
        return dcollection;
    }
    
    /**
     * Rename a dcollection
     */
    public static String rename(Long dcollectionId, String newName) {
        DCollection dcollection = (DCollection) find.ref(dcollectionId);
        dcollection.title = newName;
        dcollection.update();
        return newName;
    }
        
    /**
     * This method translates database view to the HTML view.
     * @return list of Strings
     */
	public List<String> get_field_list(String fieldName) {
    	List<String> res = new ArrayList<String>();
    	try {
    		res.add(Const.EMPTY);
			Field field = this.getClass().getField(fieldName); 
			String content = (String) field.get(this);
			res = Arrays.asList(content.split("\\s*,\\s*"));
		} catch (IllegalArgumentException e) {
			Logger.info(e.getMessage());
		} catch (IllegalAccessException e) {
			Logger.info(e.getMessage());
		} catch (SecurityException e) {
			Logger.info(e.getMessage());
		} catch (NoSuchFieldException e) {
			Logger.info(e.getMessage());
		} catch (Exception e) {
			Logger.info(e.getMessage());
		}
    	return res;
    }
    
    /**
     * Retrieve a collection object by URL.
     * @param url
     * @return collection
     */
    public static DCollection findByUrl(String url) {
//    	Logger.info("collection findByUrl: " + url);
    	DCollection res = new DCollection();
    	if (url != null && url.length() > 0 && !url.equals(Const.NONE)) {
    		res = find.where().eq(Const.URL, url).findUnique();
    	} else {
    		res.title = Const.NONE;
    	}
    	return res;
    }

    /**
     * This method returns parent collections for given collection.
     * @param quera collection
     * @return parent collection list
     */
    public static List<DCollection> getParents(DCollection collection) {
		List<DCollection> res = new ArrayList<DCollection>();
		String parentStr = collection.parents_all;
    	if (parentStr != null && parentStr.length() > 0) {
    		if (parentStr.contains(Const.COMMA)) {
    			List<String> resList = Arrays.asList(parentStr.split(Const.COMMA));
    			Iterator<String> itr = resList.iterator();
    			while (itr.hasNext()) {
        			String parentUrl = itr.next();
        	        DCollection parentCollection = find.where().eq(Const.URL, parentUrl).findUnique();
        	        res.add(parentCollection);
    			}
    		} else {
    	        DCollection parentCollection = find.where().eq(Const.URL, parentStr).findUnique();
    	        res.add(parentCollection);
    		}
    	}
		return res;
    }
    
    /**
     * Retrieve a collection by title.
     * @param title
     * @return collection object
     */
    public static DCollection findByTitle(String title) {
    	DCollection res = new DCollection();
    	if (title != null && title.length() > 0) {
    		res = find.where().eq(Const.TITLE, title).findUnique();
    	} else {
    		res.title = Const.NONE;
    	}
    	return res;
    }
    
	/**
	 * This method filters collections by title and returns a list of filtered Collection objects.
	 * @param title
	 * @return
	 */
	public static List<DCollection> filterByName(String name) {
		List<DCollection> res = new ArrayList<DCollection>();
        ExpressionList<DCollection> ll = find.where().icontains(Const.TITLE, name);
    	res = ll.findList();
		return res;
	}       
    
    public String toString() {
        return "DCollection(" + nid + ") with title: " + title + ", field_targets: " + field_targets +
        		 ", field_instances: " + field_instances +", format: " + format + ", summary: " + summary + ", value: " + value;
    }

}

