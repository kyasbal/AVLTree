import java.awt.image.SinglePixelPackedSampleModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;

/**
 Copyright (C) 2014 LimeStreem(K.I)
 https://github.com/LimeStreem/AVLTree
 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.

 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.

 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */
public class Main
{
    public static void main(String[] args)
    {
       ISearchTree<String> searchTree=new BinarySearchTree<String>(new Comparator<String>()
        {
            @Override
            public int compare(String o1, String o2)
            {
                return o1.compareTo(o2);
            }
        });
        searchTree.insert("windows");
        searchTree.insert("linux");
        searchTree.insert("mac");
        searchTree.insert("UNIX");
        searchTree.insert("CentOS");
        searchTree.insert("DOS");

        System.out.printf("現在のツリー:\n%s",searchTree.toString());
        BufferedReader input =
                new BufferedReader (new InputStreamReader(System.in));
        try{
        while (true)
        {
            System.out.println("操作を入力してください。\n i:挿入、d:削除、s:検索");
            String operation=input.readLine();
            if(operation.equals("i"))
            {
                System.out.println("挿入したい値を入力してください。\n");
                String key=input.readLine();
                searchTree.insert(key);
            }else if(operation.equals("d"))
            {
                System.out.println("削除したい値を入力してください。\n");
                String key=input.readLine();
               if( searchTree.delete(key))
               {
                   System.out.printf("%sは正常に削除されました。",key);
               }else
               {
                   System.out.printf("%sは正常に削除されませんでした。。",key);
               }
            }else if (operation.equals("s"))
            {
                System.out.println("検索したい値を入力してください。\n");
                String key=input.readLine();
               if(searchTree.searchNode(key)==null)
               {
                   System.out.printf("%sは見つかりませんでした\n",key);
               }else
               {
                   System.out.printf("%sは見つかりました。\n",key);
               }
            }else
            {
                System.out.println("その操作は認識できませんでした。");
            }
            System.out.printf("現在のツリー:\n%s",searchTree.toString());
        }
        }catch (IOException io)
        {
            io.printStackTrace();
        }
    }
}