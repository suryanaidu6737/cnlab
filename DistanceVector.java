import java.util.*;
class DistanceVector{
        public static void main(String[] args){
                Scanner sc=new Scanner(System.in);
                int n;
                int[][] cost=new int[10][10];
                int[][] dist=new int[10][10];
                int[][] nexthop=new int[10][10];
                System.out.println("enter no:of nodes");
                n=sc.nextInt();
                for(int i=0;i<n;i++){
                        for(int j=0;j<n;j++){
                                cost[i][j]=sc.nextInt();
                                dist[i][j]=cost[i][j];
                                nexthop[i][j]=j;
                        }
                }
                boolean updated;
                do{
                        updated=false;
                        for(int i=0;i<n;i++){
                                for(int j=0;j<n;j++){
                                        for(int k=0;k<n;k++){
                                                if(cost[i][k]!=999 && dist[k][j]!=999 && dist[i][j]>cost[i][k]+dist[k][j]){
                                                        dist[i][j]=cost[i][k]+dist[k][j];
                                                        nexthop[i][j]=k;
                                                        updated=true;
                                                }
                                        }
                                }
                        }
                }while(updated);
                for(int i=0;i<n;i++){
                        System.out.println("\nRouting table at node "+(i+1));
                        System.out.println("Destination\tDelay\tnexthop");
                        for(int j=0;j<n;j++){
                                System.out.println((j+1)+"\t\t"+dist[i][j]+"\t"+(i==j?"-":(nexthop[i][j]+1)));
                        }
                }




        }
}
