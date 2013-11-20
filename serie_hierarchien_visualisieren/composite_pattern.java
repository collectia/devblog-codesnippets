interface Menu {
    void print();
    int getId();
    boolean hasChildren();
}


class MenuComposite implements Menu {
    final private List<Menu> children = new ArrayList<Menu>();
    String mName;
    int mId, mParentId;
    
    MenuComposite(String name, int id, int parentId){
        this.mId = id;
        this.mParentId = parentId;
        this.mName = name;        
    }
    
    @Override
    public boolean hasChildren(){ return true; }
    
    @Override
    public int getId(){ return this.mId; }
    
    @Override
    public void print() {
        System.out.println("#name:" + mName + " id:" + mId + " parentId:" + mParentId + " countOfChildren:" + children.size());
        
        for (final Menu menu : children) {
            menu.print();
        }
    }
    
    public List<Menu> getChildren (){
        return this.children;
    }
   
    public void add(final Menu component) {
        children.add(component);
    }
 
    public void remove(final Menu component) {
        children.remove(component);
    }
}
 

class MenuClass implements Menu {
    String mName;
    int mId, mParentId;

    MenuClass(String name, int id, int parentId){
        this.mId = id;
        this.mParentId = parentId;
        this.mName = name;        
    }
    
    @Override
    public boolean hasChildren(){ return false; }
    
    @Override
    public int getId(){ return this.mId; }
    
    @Override
    public void print() {
        System.out.println("name:" + mName + " id:" + mId + " parentId:" + mParentId);
    }
}