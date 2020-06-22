import java.util.Comparator;

class SortByID implements Comparator<Country>
{ 
    @Override
    public int compare(Country o1, Country o2) {
        int res=o1.getId().compareTo(o2.getId());
        if (res>0) return 1;
        if (res<0) return -1;
        return 0;
    }
} 
  
class SortByName implements Comparator<Country>
{ 
    @Override
    public int compare(Country o1, Country o2) {
        int res=o1.getName().compareTo(o2.getName());
        if (res>0) return 1;
        if (res<0) return -1;
        return 0;
    }
} 
class SortByArea implements Comparator<Country>
{
    @Override
    public int compare(Country o1, Country o2){
        return Double.compare(o1.getArea(), o2.getArea());
    }
}
