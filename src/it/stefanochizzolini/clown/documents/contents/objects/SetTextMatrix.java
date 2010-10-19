/*
  Copyright 2007-2010 Stefano Chizzolini. http://clown.stefanochizzolini.it

  Contributors:
    * Stefano Chizzolini (original code developer, http://www.stefanochizzolini.it)

  This file should be part of the source code distribution of "PDF Clown library"
  (the Program): see the accompanying README files for more info.

  This Program is free software; you can redistribute it and/or modify it under the terms
  of the GNU Lesser General Public License as published by the Free Software Foundation;
  either version 3 of the License, or (at your option) any later version.

  This Program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY,
  either expressed or implied; without even the implied warranty of MERCHANTABILITY or
  FITNESS FOR A PARTICULAR PURPOSE. See the License for more details.

  You should have received a copy of the GNU Lesser General Public License along with this
  Program (see README files); if not, go to the GNU website (http://www.gnu.org/licenses/).

  Redistribution and use, with or without modification, are permitted provided that such
  redistributions retain the above copyright notice, license and disclaimer, along with
  this list of conditions.
*/

package it.stefanochizzolini.clown.documents.contents.objects;

import it.stefanochizzolini.clown.documents.contents.ContentScanner;
import it.stefanochizzolini.clown.objects.IPdfNumber;
import it.stefanochizzolini.clown.objects.PdfDirectObject;
import it.stefanochizzolini.clown.objects.PdfReal;

import java.util.Arrays;
import java.util.List;

/**
  'Set the text matrix' operation [PDF:1.6:5.3.1].
  <h3>Remarks</h3>
  <p>The specified matrix is not concatenated onto the current text matrix, but replaces it.</p>

  @author Stefano Chizzolini (http://www.stefanochizzolini.it)
  @since 0.0.4
  @version 0.0.8
*/
public final class SetTextMatrix
  extends Operation
{
  // <class>
  // <static>
  // <fields>
  public static final String Operator = "Tm";
  // </fields>
  // </static>

  // <dynamic>
  // <constructors>
  public SetTextMatrix(
    double a,
    double b,
    double c,
    double d,
    double e,
    double f
    )
  {
    super(
      Operator,
      new PdfReal(a),
      new PdfReal(b),
      new PdfReal(c),
      new PdfReal(d),
      new PdfReal(e),
      new PdfReal(f)
      );
  }

  public SetTextMatrix(
    List<PdfDirectObject> operands
    )
  {super(Operator,operands);}
  // </constructors>

  // <interface>
  // <public>
  @Override
  public void applyTo(
    ContentScanner.GraphicsState state
    )
  {
    state.tm = getValue();
    state.tlm = Arrays.copyOf(state.tm,state.tm.length);
  }

  public double[] getValue(
    )
  {
    return new double[]
      {
        ((IPdfNumber)operands.get(0)).getNumberValue(), // a.
        ((IPdfNumber)operands.get(1)).getNumberValue(), // b.
        ((IPdfNumber)operands.get(2)).getNumberValue(), // c.
        ((IPdfNumber)operands.get(3)).getNumberValue(), // d.
        ((IPdfNumber)operands.get(4)).getNumberValue(), // e.
        ((IPdfNumber)operands.get(5)).getNumberValue() // f.
      };
  }
  // </public>
  // </interface>
  // </dynamic>
  // </class>
}