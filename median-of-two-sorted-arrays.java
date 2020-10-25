//https://leetcode.com/problems/median-of-two-sorted-arrays/submissions/
class median-of-two-sorted-arrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size = nums1.length + nums2.length;
        int result = 0;
        int i1 = 0 , i2=0 ;
        int mediaIndex = (int)(size%2==0 ? size/2 +1 : Math.ceil((float)size/2.f));
        Integer previous = null;
        Integer current = null;
        for(int i = 0; i < mediaIndex; i++){
            if(current!=null)
                previous = current;
            if(i1<nums1.length && i2<nums2.length){
                if(nums1[i1]<nums2[i2]){
                    current = nums1[i1++];
                }else{
                    current = nums2[i2++];
                }
            }else if(i1<nums1.length){
                current = nums1[i1++];
            }else{
                current = nums2[i2++];
            }
        }
        if(size%2==0){
            return ((double)(current+previous))/2.f;
        }else{
            return current;
        }
    }
}