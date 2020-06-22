public class IsPlindrome {
    static boolean isPlindrome(char a[], int l, int r){
        if(l > r) return true;
        if(a[l] != a[r]) return false;
        return isPlindrome(a, l+1, r-1);
    }
}
