package Ex27_RemoveElement;

public class removeElement_S {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val) {
                nums[i] = val;
                i++;
            }
        }
        return i;
    }
}