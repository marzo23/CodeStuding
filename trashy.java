/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication8;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author cmarisca
 */
public class JavaApplication8 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, FileNotFoundException, UnsupportedEncodingException, IOException {
//        //countNumDigits(13, 1);
//        Node a = new Node (1);
//        a.next = new Node (2);
//        a.next.next = new Node (3);
//        a.next.next.next = new Node (4);
//        //rotate(a , 2);
//        Node b = new Node (4);
//        b.next = new Node (3);
//        b.next.next = new Node (2);
//        b.next.next.next = new Node (1);
//        //b.next.next.next.next = new Node (1);
//        //largerElems(b);
//        
//        /*String line = "ALTER TABLESPACE cmtst1 ADD TEMPFILE ;";
//        final Pattern addTmpfilePattern = Pattern.compile("(?i)(alter\\s+TABLESPACE\\s+)(.*)(\\s+ADD TEMPFILE.*)");
//        Matcher matcher = addTmpfilePattern.matcher(line);
//        if(matcher.find()){
//            System.out.println("FOUND! name:"+matcher.group(2)+":");
//        }*/
        
//        ArrayList<ArrayList<Integer>> adj = buildGraph1();
//        System.out.println("IS CYCLE: "+isCyclic(adj));
//        String input = "C:\\Users\\cmarisca\\Documents\\bkuptnxretry\\input.sql";
//        List<String> op = parseOutputToGenerateYfile(input, false);
//        parseOutputToGenerateZfileFromYfile(op, false);
////
//        String cLineToken = "alter session dewd IDENTIFIED BY \"TDT\" SET WEDWDE";
//        boolean setFlag = false;
//        String pattern = ".* identified \\s*by \".*\" (set) .*";
//        Pattern p = Pattern.compile(pattern);
//        Matcher m = p.matcher(cLineToken);
//        if (m.matches()) {
//            setFlag = true;
//            log.debug("setFlag::"+setFlag);
//        }
//        
//            String file = "C:\\Users\\cmarisca\\Downloads\\test.csv\\test.csv";
//            String newFile = "C:\\Users\\cmarisca\\Downloads\\test.csv\\test_new.csv";
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            PrintWriter writer = new PrintWriter(newFile, "UTF-8");
//            String line = null;
//            int i = 0;
//            while((line = br.readLine()) != null) {
//                if(i++>=10000) break;
//                writer.append(line+"\n");
//            }

        //findPairs(new int[]{1,3,1,5,4}, 0);
//           Node root = new Node(20);
//               root.left = new Node(15);
//   root.right = new Node(22);
//   root.left.left = new Node(10);
//   root.left.right = new Node(16);
//   root.left.right = new Node(18);
//        System.out.println("solved: "+solve(root, 15, 18));

        recorrer(new int[]{0,0,1,0,3,0,0,1,0,5,4,0});
    }
    
    public static void recorrer(int[] arr){
        int pivot = arr.length-1;
        for (int i = arr.length-1; i >= 0; i--) {
            if(arr[i]!=0){
                arr[pivot] = arr[i];
                pivot--;
            }
        }
        for (int i = 0; i < pivot; i++) {
            arr[i]=0;
        }
        
        for (int i = 0; i < arr.length; i++) {
            System.out.println("i: "+i+" a: "+arr[i]);
        }
    }
    
    public static Integer solve(Node root, int min, int max){
        if(min>max){
            int tmp = min;
            min = max;
            max = tmp;
        }
        if(root==null)
            return null;
        if(min==max)
            return min;
        if(root.value==min || root.value==max || (root.value>min && root.value<max))
            return root.value;
        if(root.value<min)
            return solve(root.right, min, max);
        if(root.value>max)
            return solve(root.left, min, max);
        return null;
    }
    
    static class Node{
        public int value;
        public Node left;
        public Node right;
        public Node(int value){
            this.value = value;
        }
    }
    
    
    static class RecentCounter {
    
        private List<Integer> requests = new ArrayList<Integer>();

        public RecentCounter() {
            requests.clear();
        }

        public int ping(int t) {
            requests.add(t);
            int count = 1;
            //System.out.println("tt: "+(t - 3000));
            for(int i = requests.size()-2; i>=0; i--){
                //System.out.println("get: "+requests.get(i));
                if(requests.get(i)>=t - 3000)
                    count++;
                else
                    break;
            }
            System.out.println("count: "+count);
            return count;
        }
    }
    
    public int findPairsBad(int[] nums, int k) {
        Map<Integer, Integer> numsM = new HashMap<Integer, Integer>();
        for(int i = 0; i<nums.length; i++){
            if(!numsM.containsKey(nums[i]))
                numsM.put(nums[i], 1);
            else
                numsM.put(nums[i], numsM.get(nums[i])+1);
        }
        
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : numsM.entrySet()){
            Integer tmp = numsM.getOrDefault(entry.getKey()-k, null);
            if(tmp != null && tmp>0){
                count++;
                numsM.put(entry.getKey()-k, tmp-1);
                numsM.put(entry.getKey(), entry.getValue()-1);
            }
        }
        return count;
    }
    
    public static int findPairs(int[] nums, int k) {
        Map<Integer, Integer> numsM = new HashMap<Integer, Integer>();
        Set<Integer> numsEx = new HashSet<Integer>();
        for(int i = 0; i<nums.length; i++){
            if(!numsM.containsKey(nums[i]))
                numsM.put(nums[i], 1);
            else
                numsM.put(nums[i], numsM.get(nums[i])+1);
        }
        
        int count = 0;
        for(Map.Entry<Integer, Integer> entry : numsM.entrySet()){
            int n = entry.getKey();
            if(numsM.containsKey(n-k) && !numsEx.contains(n+k)){
                if(n == n-k && entry.getValue()<2)
                    continue;
                count++;
                numsEx.add(n+k);
            }
        }
        return count;
    }

    
    static  List<Integer> numbersToPick = new ArrayList<Integer>();
    static  int[] arr = new int[]{6,8,11,3,2,13,15};
    
    static int pick(int n){
        if(numbersToPick.isEmpty()){
            Set<Integer> numbersToPickS = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                numbersToPickS.add(i);
            }
            for(int i: arr){
                numbersToPickS.remove(i);
            }
            for(int i: numbersToPickS){
                numbersToPick.add(i);
            }
        }
        int num = new Random().nextInt(numbersToPick.size());
        int result = numbersToPick.get(num);
        numbersToPick.remove(num);
        return result;
    }
    
    
    class NodeWeigt{
        public ArrayList<Edge> edgeList;
        public NodeWeigt(){
            ArrayList<Edge> edgeList = new ArrayList<Edge> ();
        }
    }
    
    class Edge{
        public Node src;
        public Node tgt;
        public int weight;
        public Edge(Node src, Node tgt, int weight){
            this.src = src;
            this.tgt = tgt;
            this.weight = weight;
        }
    }
    
    public static boolean kruscal(ArrayList<NodeWeigt> graph){
        ArrayList<Edge> edges = new ArrayList<Edge>();
        for(NodeWeigt node : graph)
            for(Edge edge : node.edgeList)
                if(!edges.contains(edge))
                    edges.add(edge);
        Edge[] orderedEdges = new Edge[edges.size()];
        for (int i = 0; i < edges.size(); i++) {
            orderedEdges[i] = edges.get(i);
        }
        ArrayList<Edge> output = new ArrayList<Edge>();
        for (int i = 0; i < orderedEdges.length; i++) {
            //if(!output.contains(orderedEdges[i]) && )
        }
            return true;
        
    }
    
    public static boolean findCycle(ArrayList<Edge> tree, Edge newEdge){
        ArrayList<Edge> tmpTree = new ArrayList<Edge>(tree);
        tmpTree.add(newEdge);
        //List<Node> existingNodes = 
        for (int i = 0; i < 10; i++) {
            
        }
        return true;
    }
    
    public static void orderEdges(Edge[] edgeList, int start, int end){
        int min = start , max = end;
        int pivot = edgeList[edgeList.length/2].weight;
        do{
            while(edgeList[min].weight>pivot) min++;
            while(edgeList[max].weight<pivot) max--;
            if(min<=max){
                Edge tmp = edgeList[min];
                edgeList[min] = edgeList[max];
                edgeList[max] = tmp;
                min++;
                max--;
            }
        }while(min<=max);
        if(start<max)
            orderEdges(edgeList, start, max);
        if(end>min)
            orderEdges(edgeList, min, end);
    }
    
    
    public static ArrayList<ArrayList<Integer>> buildGraph1(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(0);
        adj.add(tmp); //0
        
        return adj;
    }
    
    public static ArrayList<ArrayList<Integer>> buildGraph(){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        tmp.add(2);
        adj.add(tmp); //0
        
        tmp = new ArrayList<Integer>();
        tmp.add(3);
        tmp.add(0);
        adj.add(tmp);// 1
        
        tmp = new ArrayList<Integer>();
        tmp.add(3);
        tmp.add(1);
        adj.add(tmp); //2
        
        tmp = new ArrayList<Integer>();
        tmp.add(1);
        adj.add(tmp); //3
        
        return adj;
    }
    
    static boolean isCyclic(ArrayList<ArrayList<Integer>> adj)
    {
        if(adj==null || adj.size()<1) return false;
        ArrayList<Integer> processed = new ArrayList<Integer>();
        for(int i =0; i<adj.size(); i++){
            boolean result = isCyclic(adj, processed, i);
            if(result)
                return true;
            processed.remove(processed.size()-1);
        }
        return false;
    }
    
    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adj, ArrayList<Integer> processed, int node ){
        if(processed.contains(node)) return true;
        processed.add(node);
        for(int i =0; i<adj.get(node).size(); i++){
            boolean result = isCyclic(adj, processed, adj.get(node).get(i));
            if(result)
                return true;
            if(processed.size()>0)
                processed.remove(processed.size()-1);
        }
        return false;
    }
    
//    public static void largerElems(Node head){
//        Node tmp = head;
//        while(tmp!=null){
//            Node tmp2 = tmp.next;
//            while(tmp2!=null && tmp.data>tmp2.data){
//                tmp2 = tmp2.next;
//            }
//            if(tmp2==null)
//                System.out.println("-1 ");
//            else
//                System.out.println(tmp2.data+" ");
//            tmp = tmp.next;
//        }
//    }
//    
//    static class Node{
//        int data;
//        Node next;
//        Node(int d){
//            data=d;
//            next=null;
//        }
//    }
//    
//    public static Node rotate(Node head, int k) {
//        if(head == null)
//            return null;
//        Node newHead = head;
//        Node previous = null;
//        while(newHead.next != null){
//            System.out.println("holi");
//            newHead = newHead.next;
//        }
//        newHead.next = head;
//        newHead = head;
//        for(int i=0; i<k; i++){
//            previous = newHead;
//            newHead = newHead.next;
//        }
//        previous.next = null;
//        return newHead;
//    }
    
    public static int countNumDigits(int numberInput, int digit){
        int number = numberInput;
        String numberStr = String.valueOf(number);
        System.out.println("string: "+numberStr);
        int acum = 0;
        for (int i = 1; i < numberStr.length(); i++) {
            int denom = (int) Math.pow(10, i);
            int currentNum = number % denom;
            int currDigit =  digit * denom/10;
            System.out.println("denom: "+denom);
            System.out.println("currentNum: "+currentNum);
            System.out.println("currDigit: "+currDigit);
            if(currentNum>=currDigit){
                System.out.println("denom/10: "+denom/10);
                System.out.println("Math.floor(currentNum/denom: "+Math.floor(currentNum/denom));
                acum+= (denom/10) +  Math.floor(currentNum/denom);
            }
            number -=currentNum;
        }
        
        System.out.println("ACUM: "+acum);
        return acum;
    }
}








/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author cmarisca
 */
public class JavaApplication7 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        int[] input = new int[]{3,5,1,7,5,2,1,2,6,7,0,3,9,7,2,9,7,2,4,6,0,7,8,9,11};
//        //mergeSortCall(input);
//        //System.out.println("find sum res: "+findSum(new int[]{1, 5, 3, 2}));
//        int[] input1 = new int[]{1, 5, 9, 10, 15, 20};
//        int[] input2 = new int[]{2, 3, 8, 13};
//        //mergeArraysNoMemory(input1, input2);
//        countNumDigits(13, 1);
//        Stack<Integer> s = new Stack<Integer>();
//        
//        final Pattern addTmpfilePattern = Pattern.compile("((?i)alter tablespace\\s+)([^\\s]+)(\\s+(?i)add tempfile)");
//        String line = "ALTER TABLESPACE TEMP2 ADD TEMPFILE";
//        Matcher matcher = addTmpfilePattern.matcher(line);
//        if(matcher.find())
//            System.out.println("tablespace name:::"+matcher.group(2)+":::");
//        line="ALTER SESSION SET CONTAINER = \"CDB$ROOT\" ;";
//        if(line.toUpperCase().contains("ALTER SESSION SET CONTAINER") && line.toUpperCase().contains("CDB$ROOT"))
//            System.out.println("HOLIIII");
        
        A test = new A2("holis");
        test.test();
    }
    
    
    public static int countNumDigits(int numberInput, int digit){
        int number = numberInput;
        String numberStr = String.valueOf(number);
        int acum = 0;
        for (int i = 1; i < numberStr.length(); i++) {
            int denom = (int) Math.pow(10, i);
            int currentNum = number % denom;
            int currDigit =  digit * denom/10;
            if(currentNum>=currDigit){
                acum+= denom/10 +  Math.floor(currentNum/denom);
            }
            number -=currentNum;
        }
        
        System.out.println("ACUM: "+acum);
        return acum;
    }
    
    public static void buildLargestNumFromArray(int[] input){
        
    }
    
    public static void mergeArraysNoMemory(int[] input1, int[] input2){
        System.out.println("\ninput1 before: ");
        printArray(input1);
        System.out.println("\ninput2 before: ");
        printArray(input2);
        System.out.println("\n");
        for (int i = 0; i < input1.length; i++) {
            if(input1[i]>input2[0]){
                int j = 1;
                int in2 = input2[0];
                while(j<input2.length && input2[j]<input1[i]){
                    input2[j-1] = input2[j++];
                }
                j--;
                input2[j] = input1[i];
                input1[i] = in2;
            }
        }
        System.out.println("\ninput1 after: ");
        printArray(input1);
        System.out.println("\ninput2 after: ");
        printArray(input2);
    }
    
    public static void printArray(int[] input){
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i]+", ");
        }
    }
    
    public static void quickSort(int[] input){
        System.out.println("\nQUICK SORT INPUT: ");
        printArray(input);
        quickSort(input, 0, input.length-1);
        System.out.println("\nQUICK SORT OUTPUT: ");
        printArray(input);
    }
    
    public static void quickSort(int[] input, int start, int end){
        if(end<=start)
            return;
        int pivot = input[start+(end-start)/2];
        int min =start, max =end;
        while(min<=max){
            while(input[min]<pivot){
                min++;
            }
            while(input[max]>pivot){
                max--;
            }
            if(min<=max){
                int tmp = input[min];
                input[min] = input[max];
                input[max] = tmp;
                min++;
                max--;
            }
        }
        if(start<max)
            quickSort(input, start, max);
        if(min<end)
            quickSort(input, min, end);
    }
    
    public static void mergeSortCall(int[] input){
        System.out.println("\nMERGE SORT INPUT: ");
        printArray(input);
        mergeSort(input);
        System.out.println("\nMERGE SORT OUTPUT: ");
        printArray(input);
    }
    
    public static void mergeSort(int[] input){
        int half = input.length/2;
        if(half<1)
            return;
        int[] rigth = new int[half];
        int[] left = new int[input.length - half];
        for (int i = 0; i < input.length; i++) {
            if(i<half)
                rigth[i] = input[i];
            else
                left[i-half] = input[i];
        }
        mergeSort(rigth);
        mergeSort(left);
        int[] output = merge(rigth, left);
        for (int i = 0; i < input.length; i++) {
            input[i] = output[i];
        }
    }
    
    public static int[] merge(int[] input1, int[] input2){
        int[] output = new int[input1.length+input2.length];
        int i = 0, j = 0, k = 0;
        while(k<output.length){
            if(i<input1.length && (j>=input2.length || input1[i]<input2[j] )){
                output[k++] = input1[i++];
            }else{
                output[k++] = input2[j++];
            }
        }
        return output;
    }
    
    public static int findSum(int[] arr){
        int count = 0;
        mergeSort(arr);
        for (int i = arr.length-1; i >= 2; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[i]<=arr[j])
                    break;
                for (int k = j+1; k < i; k++) {
                    if(arr[j]+arr[k] == arr[i])
                        count++;
                }
            }
            
        }
        return count;
    }
    
    public static void findSubArraySum(int n, int sum, int arr[]){
        int csum=0,header=0,flag=0;
        for(int j=0;j<n;j++)
        {
            csum+=arr[j];
            while(csum>sum){ 
                csum=csum-arr[header];
                header++;
            }   
            if(csum==sum){
                flag=1;
                System.out.println((header+1)+" "+(j+1));
                break;

            }
        }          
        if(flag==0)
            System.out.println(-1);
    }
}



abstract class A{
        String aaa;
        
        public A(String aa){
            this.aaa = aa;
        }
        
        protected void validation1(){
            System.out.println("VALIDATION 1");
        }
        protected void validation2(){
            System.out.println("VALIDATION 2");
        }
        public void test(){
            System.out.println("ENTRA TEST A");
            validation1();
            logic(this.aaa);
            validation2();
        }
        
        abstract protected void logic(String aa);
    }
    
    class A1 extends A{

        public A1(String aa) {
            super(aa);
        }
        @Override
        protected void logic(String aa) {
            System.out.println("entra A1");
            System.out.println("aa: "+aa);
        }
        
    }
    
    class A2 extends A{

        public A2(String aa) {
            super(aa);
        }
        @Override
        protected void logic(String aa) {
            System.out.println("entra A2");
            System.out.println("aa: "+aa);
        }
        
    }
    