import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author leandros
 */
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;

    private String name;

    private Category parent;

    private Set<Category> children = new HashSet<>();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getParent() {
        return parent;
    }

    /**
     * Sets parent also updating the parent's child
     * @param parent
     */
    public void setParent(Category parent) {
        this.parent = parent;
        parent.getChildren().add(this);
    }

    public Set<Category> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return "com.company.Category{" + "id=" + id + ", name=" + name + ", parent=" + (parent != null ? parent.getName() : "null") + ", children=" + children.toString() + '}';
    }

    /**
     * Check if category is leaf node
     * @return true if there are no child categories in this category, otherwise false
     */
    public boolean isLeaf() {
        return children.isEmpty();
    }

    /**
     * Check if category is root node
     * @return  true if this category has no parent
     */
    public boolean isRoot() {
        return (parent == null);
    }

    /**
     * Gets the category's depth
     * @return the number of parent categories
     */
    public int depth() {
        int depth = 0;

        Category c = this;
        while ((c = c.getParent()) != null) {
            depth++;
        }

        return depth;
    }


}
