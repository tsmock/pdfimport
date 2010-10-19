/*
  Copyright 2009 Stefano Chizzolini. http://clown.stefanochizzolini.it

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

import it.stefanochizzolini.clown.objects.PdfDirectObject;

import java.util.List;

/**
  Weakly-typed operation.
  <h3>Remarks</h3>
  <p>This is used to model operations which do not have a dedicated type.</p>

  @author Stefano Chizzolini (http://www.stefanochizzolini.it)
  @since 0.0.8
  @version 0.0.8
*/
public final class GenericOperation
  extends Operation
{
  // <class>
  // <dynamic>
  // <constructors>
  public GenericOperation(
    String operator
    )
  {super(operator);}

  public GenericOperation(
    String operator,
    PdfDirectObject operand
    )
  {super(operator,operand);}

  public GenericOperation(
    String operator,
    List<PdfDirectObject> operands
    )
  {super(operator,operands);}
  // </constructors>
  // </dynamic>
  // </class>
}