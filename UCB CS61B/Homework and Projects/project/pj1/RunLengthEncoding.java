package com.cs61b.project1;

import java.util.Arrays;

/* RunLengthEncoding.java */

/**
 *  The RunLengthEncoding class defines an object that run-length encodes
 *  a PixImage object.  Descriptions of the methods you must implement appear
 *  below.  They include constructors of the form
 *
 *      public RunLengthEncoding(int width, int height);
 *      public RunLengthEncoding(int width, int height, int[] red, int[] green,
 *                               int[] blue, int[] runLengths) {
 *      public RunLengthEncoding(PixImage image) {
 *
 *  that create a run-length encoding of a PixImage having the specified width
 *  and height.
 *
 *  The first constructor creates a run-length encoding of a PixImage in which
 *  every pixel is black.  The second constructor creates a run-length encoding
 *  for which the runs are provided as parameters.  The third constructor
 *  converts a PixImage object into a run-length encoding of that image.
 *
 *  See the README file accompanying this project for additional details.
 */

import java.util.Iterator;

import com.cs61b.hw5.DList;
import com.cs61b.hw5.DListNode;
import com.cs61b.hw5.InvalidNodeException;
import com.cs61b.hw5.List;

@SuppressWarnings("rawtypes")
public class RunLengthEncoding implements Iterable {

  /**
   *  Define any variables associated with a RunLengthEncoding object here.
   *  These variables MUST be private.
   */

    private DList runsList;
    private int width, height;


  /**
   *  The following methods are required for Part II.
   */

  /**
   *  RunLengthEncoding() (with two parameters) constructs a run-length
   *  encoding of a black PixImage of the specified width and height, in which
   *  every pixel has red, green, and blue intensities of zero.
   *
   *  @param width the width of the image.
   *  @param height the height of the image.
   */

  public RunLengthEncoding(int width, int height) 
  {
    // Your solution here.
      this(width, height, new int[]{0}, new int[]{0}, new int[]{0}, new int[]{width * height});
  }

  /**
   *  RunLengthEncoding() (with six parameters) constructs a run-length
   *  encoding of a PixImage of the specified width and height.  The runs of
   *  the run-length encoding are taken from four input arrays of equal length.
   *  Run i has length runLengths[i] and RGB intensities red[i], green[i], and
   *  blue[i].
   *
   *  @param width the width of the image.
   *  @param height the height of the image.
   *  @param red is an array that specifies the red intensity of each run.
   *  @param green is an array that specifies the green intensity of each run.
   *  @param blue is an array that specifies the blue intensity of each run.
   *  @param runLengths is an array that specifies the length of each run.
   *
   *  NOTE:  All four input arrays should have the same length (not zero).
   *  All pixel intensities in the first three arrays should be in the range
   *  0...255.  The sum of all the elements of the runLengths array should be
   *  width * height.  (Feel free to quit with an error message if any of these
   *  conditions are not met--though we won't be testing that.)
   */

  public RunLengthEncoding(int width, int height, int[] red, int[] green,
                           int[] blue, int[] runLengths) {
    // Your solution here.
      this.width = width;
      this.height = height;
      runsList = new DList();
      Run run;
      for(int i = 0; i < runLengths.length; i++)
      {
          run = new Run(runLengths[i], (short)red[i], (short)green[i], (short)blue[i]);
          runsList.insertBack(run);
      }
  }

  /**
   *  getWidth() returns the width of the image that this run-length encoding
   *  represents.
   *
   *  @return the width of the image that this run-length encoding represents.
   */

  public int getWidth() {
    // Replace the following line with your solution.
    return this.width;
  }

  /**
   *  getHeight() returns the height of the image that this run-length encoding
   *  represents.
   *
   *  @return the height of the image that this run-length encoding represents.
   */
  public int getHeight() {
    // Replace the following line with your solution.
    return this.height;
  }

  /**
   *  iterator() returns a newly created RunIterator that can iterate through
   *  the runs of this RunLengthEncoding.
   *
   *  @return a newly created RunIterator object set to the first run of this
   *  RunLengthEncoding.
   */
  public RunIterator iterator() {
    // Replace the following line with your solution.
    return new RunIterator((DListNode) runsList.front());
    // You'll want to construct a new RunIterator, but first you'll need to
    // write a constructor in the RunIterator class.
  }

  /**
   *  toPixImage() converts a run-length encoding of an image into a PixImage
   *  object.
   *
   *  @return the PixImage that this RunLengthEncoding encodes.
   */
    public PixImage toPixImage()
    {
        // Replace the following line with your solution.
        PixImage image = new PixImage(width, height);
        Iterator<int[]> it = iterator();
        int i = 0, j = 0;
        while (it.hasNext())
        {
            int[] cur = it.next();
            int numbers = cur[0];
            while(numbers-- > 0)
            {
                if(j >= this.height) break;
                if(i == this.width)
                {
                    i = 0;
                    j++;
                }
                image.setPixel(i, j, (short)cur[1], (short)cur[2], (short)cur[3]);
                i++;
            }

        }
        return image;
    }

  /**
   *  toString() returns a String representation of this RunLengthEncoding.
   *
   *  This method isn't required, but it should be very useful to you when
   *  you're debugging your code.  It's up to you how you represent
   *  a RunLengthEncoding as a String.
   *
   *  @return a String representation of this RunLengthEncoding.
   */
    public String toString()
    {
        // Replace the following line with your solution.
        StringBuilder sb = new StringBuilder(1 << 6);
        Iterator<int[]> iterator = iterator();
        while (iterator.hasNext())
        {
            sb.append(Arrays.toString(iterator.next()));
            sb.append("\n");
        }
        return sb.toString();
    }


  /**
   *  The following methods are required for Part III.
   */

  /**
   *  RunLengthEncoding() (with one parameter) is a constructor that creates
   *  a run-length encoding of a specified PixImage.
   * 
   *  Note that you must encode the image in row-major format, i.e., the second
   *  pixel should be (1, 0) and not (0, 1).
   *
   *  @param image is the PixImage to run-length encode.
   */
    public RunLengthEncoding(PixImage image)
    {
        // Your solution here, but you should probably leave the following line
        // at the end.
        this.width = image.getWidth();
        this.height = image.getHeight();
        runsList = new DList();
        
        int j = 0;
        for(int i = 0; i < this.width; )
        {
            if(j >= this.height) break;
            Pixel last = image.getPixel(i, j);
            int consecutives = 0;
            while(j < this.height && last.equals(image.getPixel(i, j)))
            {
                consecutives++;
                i++;
                if(i == this.width)
                {
                    i = 0;
                    j++;
                }
            }
            runsList.insertBack(new Run(consecutives, last));
        }
        check();
    }

  /**
   *  check() walks through the run-length encoding and prints an error message
   *  if two consecutive runs have the same RGB intensities, or if the sum of
   *  all run lengths does not equal the number of pixels in the image.
   */
  public void check() {
    // Your solution here.
      Iterator<int[]> it = iterator();
      int[] last = new int[4];
      int[] cur = new int[4];
      int sum = 0;
      while(it.hasNext())
      {
          cur = it.next();
          sum += cur[0];
          if(last.equals(cur))
          {
              System.out.println("Error: two consecutive runs have the same RGB intensities");
              return;
          }
          else
          {
              last = cur;
          }
      }
      if(sum != this.width * this.height)
      {
          System.out.println("Error: the sum of all run lengths does not equal the number of pixels in the image");
      }
  }


  /**
   *  The following method is required for Part IV.
   */

  /**
   *  setPixel() modifies this run-length encoding so that the specified color
   *  is stored at the given (x, y) coordinates.  The old pixel value at that
   *  coordinate should be overwritten and all others should remain the same.
   *  The updated run-length encoding should be compressed as much as possible;
   *  there should not be two consecutive runs with exactly the same RGB color.
   *
   *  @param x the x-coordinate of the pixel to modify.
   *  @param y the y-coordinate of the pixel to modify.
   *  @param red the new red intensity to store at coordinate (x, y).
   *  @param green the new green intensity to store at coordinate (x, y).
   *  @param blue the new blue intensity to store at coordinate (x, y).
 * @throws InvalidNodeException 
   */
    public void setPixel(int x, int y, short red, short green, short blue) throws InvalidNodeException
    {
        // Your solution here, but you should probably leave the following line
        // at the end.
        int pos = this.width * y + x + 1;
        if(pos > this.width * this.height && pos < 0){ return ;}
        
        int sum = 0;
        DListNode cur= (DListNode) runsList.front();
        DListNode next = (DListNode) runsList.front();
        
        while(next.isValidNode() && sum < pos)
        {
            cur = next;
            sum += ((Run)cur.item()).getNumber();
            next = (DListNode) next.next();
        }
        
        Pixel insertPixel = new Pixel(red, green, blue);
        Run insertRun = new Run(1, insertPixel);
        Pixel curPixel = new Pixel(((Run) cur.item()).getPixel());
        if(insertPixel.equals(curPixel)){ return ;}
        
        int curNum = ((Run) cur.item()).getNumber();
        // 没有到末尾
        if (next.isValidNode())
        {
            if (curNum == 1)
            {
                if(cur.prev().isValidNode())
                {
                    int prevNum = ((Run) cur.prev().item()).getNumber();
                    int nextNum = ((Run) next.item()).getNumber();
                    
                    if (!(insertPixel.equals(((Run) cur.prev().item()).getPixel())) &&
                            insertPixel.equals(((Run) next.item()).getPixel()))
                    {
                        cur.remove();
                        ((Run) next.item()).setNumber(nextNum + 1);
                    }
                    else if(insertPixel.equals(((Run) cur.prev().item()).getPixel()) &&
                            !(insertPixel.equals(((Run) next.item()).getPixel())))
                    {
                        ((Run) cur.prev().item()).setNumber(prevNum + 1);
                        cur.remove();
                    }
                    else if(insertPixel.equals(((Run) cur.prev().item()).getPixel()) &&
                            insertPixel.equals(((Run) next.item()).getPixel()))
                    {
                        cur.prev().remove();
                        cur.remove();
                        ((Run) next.item()).setNumber(prevNum + nextNum + 1);
                    }
                    else
                    {
                        ((Run) cur.item()).setPixel(insertPixel);
                    }
                }
                else if(!cur.prev().isValidNode())
                {
                    int nextNum = ((Run) next.item()).getNumber();
                    if (insertPixel.equals(((Run) next.item()).getPixel()))
                    {
                        cur.remove();
                        ((Run) next.item()).setNumber(nextNum + 1);
                    }
                    else
                    {
                        ((Run) cur.item()).setPixel(insertPixel);
                    }
                }
            }
            // 要插入的pixel处于压缩后的里面
            else if(curNum > 1)
            {
                if(cur.prev().isValidNode())
                {
                    int prevNum = ((Run) cur.prev().item()).getNumber();
                    int nextNum = ((Run) next.item()).getNumber();
                    if(pos == (sum - curNum + 1))
                    {
                        if(insertPixel.equals(((Run) cur.prev().item()).getPixel()))
                        {
                            ((Run) cur.prev().item()).setNumber(prevNum + 1);
                            ((Run) cur.item()).setNumber(curNum - 1);
                        }
                        else
                        {
                            cur.insertBefore(insertRun);
                            ((Run) cur.item()).setNumber(curNum - 1);
                        }
                    }
                    else if (pos == sum)
                    {
                        if(insertPixel.equals(((Run) next.item()).getPixel()))
                        {
                            ((Run) next.item()).setNumber(nextNum + 1);
                            ((Run) cur.item()).setNumber(curNum - 1);
                        }
                        else
                        {
                            cur.insertAfter(insertRun);
                            ((Run) cur.item()).setNumber(curNum - 1);
                        }
                    }
                    else
                    {
                        ((Run) cur.item()).setNumber(pos - (sum - curNum) - 1);
                        cur.insertAfter(insertRun);
                        cur.next().insertAfter(new Run(1, curPixel));
                    }
                }
                // 前面无节点，后面有节点，当前节点数 > 1
                else if (!cur.prev().isValidNode())
                {
                    if(pos == 1)
                    {
                        cur.insertBefore(insertRun);
                        ((Run) cur.item()).setNumber(curNum - 1);
                    }
                    else if (pos > 1 && pos < curNum)
                    {
                        ((Run) cur.item()).setNumber(pos - 1);
                        cur.insertAfter(insertRun);
                        cur.next().insertAfter(new Run(curNum - pos, curPixel));
                    }
                    else if(pos == curNum)
                    {
                        ((Run) cur.item()).setNumber(curNum - 1);
                        if (insertPixel.equals(((Run) next.item()).getPixel()))
                        {
                            int nextNum = ((Run) next.item()).getNumber();
                            ((Run) next.item()).setNumber(nextNum + 1);
                        }
                        else
                        {
                            cur.insertAfter(insertRun);
                        }
                    }
                }
            }
        }
        else if(!next.isValidNode())
        {
            // 已经跑到末尾
            if (curNum == 1)
            {
                if(cur.prev().isValidNode())
                {
                    int prevNum = ((Run) cur.prev().item()).getNumber();
                    if(insertPixel.equals(((Run) cur.prev().item()).getPixel()))
                    {
                        ((Run) cur.prev().item()).setNumber(prevNum + 1);
                        cur.remove();
                    }
                    else
                    {
                        ((Run) cur.item()).setPixel(insertPixel);
                    }
                }
                // 只有一个点的情况
                else
                {
                    ((Run) cur.item()).setPixel(insertPixel);
                }
            }
            else
            {
                if(cur.prev().isValidNode())
                {
                    int prevNum = ((Run) cur.prev().item()).getNumber();
                    if(pos == (sum - curNum + 1))
                    {
                        if(insertPixel.equals(((Run) cur.prev().item()).getPixel()))
                        {
                            ((Run) cur.prev().item()).setNumber(prevNum + 1);
                            ((Run) cur.item()).setNumber(curNum - 1);
                        }
                        else
                        {
                            ((Run) cur.item()).setNumber(pos - (sum - curNum) - 1);
                            cur.insertAfter(insertRun);
                            if(sum - pos > 0)
                            {
                                cur.insertAfter(new Run(sum - pos, curPixel));
                            }
                        }
                    }
                    else
                    {
                        ((Run) cur.item()).setNumber(pos - (sum - curNum) - 1);
                        cur.insertAfter(insertRun);
                        if(sum - pos > 0)
                        {
                            cur.insertAfter(new Run(sum - pos, curPixel));
                        }
                    }
                }
                // 压缩成一个点的情况
                else
                {
                    ((Run) cur.item()).setNumber(pos - (sum - curNum) - 1);
                    cur.insertAfter(insertRun);
                    if(sum - pos > 0)
                    {
                        cur.insertAfter(new Run(sum - pos, curPixel));
                    }
                }
            }
        }
        
        check();
    }


  /**
   * TEST CODE:  YOU DO NOT NEED TO FILL IN ANY METHODS BELOW THIS POINT.
   * You are welcome to add tests, though.  Methods below this point will not
   * be tested.  This is not the autograder, which will be provided separately.
   */


  /**
   * doTest() checks whether the condition is true and prints the given error
   * message if it is not.
   *
   * @param b the condition to check.
   * @param msg the error message to print if the condition is false.
   */
  private static void doTest(boolean b, String msg) {
    if (b) {
      System.out.println("Good.");
    } else {
      System.err.println(msg);
    }
  }

  /**
   * array2PixImage() converts a 2D array of grayscale intensities to
   * a grayscale PixImage.
   *
   * @param pixels a 2D array of grayscale intensities in the range 0...255.
   * @return a new PixImage whose red, green, and blue values are equal to
   * the input grayscale intensities.
   */
  private static PixImage array2PixImage(int[][] pixels) {
    int width = pixels.length;
    int height = pixels[0].length;
    PixImage image = new PixImage(width, height);

    for (int x = 0; x < width; x++) {
      for (int y = 0; y < height; y++) {
        image.setPixel(x, y, (short) pixels[x][y], (short) pixels[x][y],
                       (short) pixels[x][y]);
      }
    }

    return image;
  }
  
  /**
   * setAndCheckRLE() sets the given coordinate in the given run-length
   * encoding to the given value and then checks whether the resulting
   * run-length encoding is correct.
   *
   * @param rle the run-length encoding to modify.
   * @param x the x-coordinate to set.
   * @param y the y-coordinate to set.
   * @param intensity the grayscale intensity to assign to pixel (x, y).
 * @throws InvalidNodeException 
   */
  private static void setAndCheckRLE(RunLengthEncoding rle,
                                     int x, int y, int intensity) throws InvalidNodeException {
    rle.setPixel(x, y,
                 (short) intensity, (short) intensity, (short) intensity);
    rle.check();
  }

  /**
   * main() runs a series of tests of the run-length encoding code.
 * @throws InvalidNodeException 
   */
  public static void main(String[] args) throws InvalidNodeException {
    // Be forwarned that when you write arrays directly in Java as below,
    // each "row" of text is a column of your image--the numbers get
    // transposed.
    PixImage image1 = array2PixImage(new int[][] { { 0, 3, 6 },
                                                   { 1, 4, 7 },
                                                   { 2, 5, 8 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 3x3 image.  Input image:");
    System.out.print(image1);
    RunLengthEncoding rle1 = new RunLengthEncoding(image1);
    rle1.check();
    System.out.println("Testing getWidth/getHeight on a 3x3 encoding.");
    doTest(rle1.getWidth() == 3 && rle1.getHeight() == 3,
           "RLE1 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x3 encoding.");
    doTest(image1.equals(rle1.toPixImage()),
           "image1 -> RLE1 -> image does not reconstruct the original image");

    /* Test set encoding */
    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 0, 42);
    image1.setPixel(0, 0, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           /*
                       array2PixImage(new int[][] { { 42, 3, 6 },
                                                    { 1, 4, 7 },
                                                    { 2, 5, 8 } })),
           */
           "Setting RLE1[0][0] = 42 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 1, 0, 42);
    image1.setPixel(1, 0, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[1][0] = 42 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 1, 2);
    image1.setPixel(0, 1, (short) 2, (short) 2, (short) 2);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[0][1] = 2 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 0, 0, 0);
    image1.setPixel(0, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[0][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 2, 2, 7);
    image1.setPixel(2, 2, (short) 7, (short) 7, (short) 7);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[2][2] = 7 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 2, 2, 42);
    image1.setPixel(2, 2, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[2][2] = 42 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle1, 1, 2, 42);
    image1.setPixel(1, 2, (short) 42, (short) 42, (short) 42);
    doTest(rle1.toPixImage().equals(image1),
           "Setting RLE1[1][2] = 42 fails.");


    PixImage image2 = array2PixImage(new int[][] { { 2, 3, 5 },
                                                   { 2, 4, 5 },
                                                   { 3, 4, 6 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on another 3x3 image.  Input image:");
    System.out.print(image2);
    RunLengthEncoding rle2 = new RunLengthEncoding(image2);
    rle2.check();
    System.out.println("Testing getWidth/getHeight on a 3x3 encoding.");
    doTest(rle2.getWidth() == 3 && rle2.getHeight() == 3,
           "RLE2 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x3 encoding.");
    doTest(rle2.toPixImage().equals(image2),
           "image2 -> RLE2 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle2, 0, 1, 2);
    image2.setPixel(0, 1, (short) 2, (short) 2, (short) 2);
    doTest(rle2.toPixImage().equals(image2),
           "Setting RLE2[0][1] = 2 fails.");

    System.out.println("Testing setPixel() on a 3x3 encoding.");
    setAndCheckRLE(rle2, 2, 0, 2);
    image2.setPixel(2, 0, (short) 2, (short) 2, (short) 2);
    doTest(rle2.toPixImage().equals(image2),
           "Setting RLE2[2][0] = 2 fails.");


    PixImage image3 = array2PixImage(new int[][] { { 0, 5 },
                                                   { 1, 6 },
                                                   { 2, 7 },
                                                   { 3, 8 },
                                                   { 4, 9 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 5x2 image.  Input image:");
    System.out.print(image3);
    RunLengthEncoding rle3 = new RunLengthEncoding(image3);
    rle3.check();
    System.out.println("Testing getWidth/getHeight on a 5x2 encoding.");
    doTest(rle3.getWidth() == 5 && rle3.getHeight() == 2,
           "RLE3 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 5x2 encoding.");
    doTest(rle3.toPixImage().equals(image3),
           "image3 -> RLE3 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 4, 0, 6);
    image3.setPixel(4, 0, (short) 6, (short) 6, (short) 6);
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[4][0] = 6 fails.");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 0, 1, 6);
    image3.setPixel(0, 1, (short) 6, (short) 6, (short) 6);
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[0][1] = 6 fails.");

    System.out.println("Testing setPixel() on a 5x2 encoding.");
    setAndCheckRLE(rle3, 0, 0, 1);
    image3.setPixel(0, 0, (short) 1, (short) 1, (short) 1);
    doTest(rle3.toPixImage().equals(image3),
           "Setting RLE3[0][0] = 1 fails.");


    PixImage image4 = array2PixImage(new int[][] { { 0, 3 },
                                                   { 1, 4 },
                                                   { 2, 5 } });

    System.out.println("Testing one-parameter RunLengthEncoding constuctor " +
                       "on a 3x2 image.  Input image:");
    System.out.print(image4);
    RunLengthEncoding rle4 = new RunLengthEncoding(image4);
    rle4.check();
    System.out.println("Testing getWidth/getHeight on a 3x2 encoding.");
    doTest(rle4.getWidth() == 3 && rle4.getHeight() == 2,
           "RLE4 has wrong dimensions");

    System.out.println("Testing toPixImage() on a 3x2 encoding.");
    doTest(rle4.toPixImage().equals(image4),
           "image4 -> RLE4 -> image does not reconstruct the original image");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 2, 0, 0);
    image4.setPixel(2, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[2][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 1, 0, 0);
    image4.setPixel(1, 0, (short) 0, (short) 0, (short) 0);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[1][0] = 0 fails.");

    System.out.println("Testing setPixel() on a 3x2 encoding.");
    setAndCheckRLE(rle4, 1, 0, 1);
    image4.setPixel(1, 0, (short) 1, (short) 1, (short) 1);
    doTest(rle4.toPixImage().equals(image4),
           "Setting RLE4[1][0] = 1 fails.");
  }
}
