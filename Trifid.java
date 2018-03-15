import java.util.Arrays;

public abstract class Trifid
{
    String someString = "tank on the hill";
    String[] userArray = someString.split("");
    int numberCode;
    //char[][][] coordCube = new char[3][3][3]
    char[][][] coordCube = {
                              {
                                {'a','b','c'}, {'d','e','f'}, {'g','h','i'}
                              },
                              {
                                {'j','k','l'}, {'m','n','o'}, {'p','q','r'}
                              },
                              {
                                {'s','t','u'}, {'v','w','x'}, {'y','z','.'}
                              }
                            };
    public static void encryption();
    {
    for(int i = 0; i < coordCube.length ; i++)
    {
        for(int j = 0; j < coordCube[i].length ; j++)
        {
            for(int k = 0; k < coordCube[j].length ; k++)
            {
              System.out.print(coordCube[i][j][k]);
            }
          }
        }


    // for(int i = 0; i < userArray; i++)
    // {
    //   for()
    // }
  }
}
