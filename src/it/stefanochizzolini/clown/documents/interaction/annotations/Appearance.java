/*
  Copyright 2008 Stefano Chizzolini. http://clown.stefanochizzolini.it

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

package it.stefanochizzolini.clown.documents.interaction.annotations;

import it.stefanochizzolini.clown.documents.Document;
import it.stefanochizzolini.clown.objects.PdfDictionary;
import it.stefanochizzolini.clown.objects.PdfDirectObject;
import it.stefanochizzolini.clown.objects.PdfIndirectObject;
import it.stefanochizzolini.clown.objects.PdfName;
import it.stefanochizzolini.clown.objects.PdfObjectWrapper;
import it.stefanochizzolini.clown.util.NotImplementedException;

/**
  Appearance [PDF:1.6:8.4.4].

  @author Stefano Chizzolini (http://www.stefanochizzolini.it)
  @since 0.0.7
  @version 0.0.7
*/
public class Appearance
  extends PdfObjectWrapper<PdfDictionary>
{
  // <class>
  // <dynamic>
  // <constructors>
  public Appearance(
    Document context
    )
  {
    super(
      context.getFile(),
      new PdfDictionary()
      );
  }

  public Appearance(
    PdfDirectObject baseObject,
    PdfIndirectObject container
    )
  {super(baseObject,container);}
  // </constructors>

  // <interface>
  // <public>
  @Override
  public Appearance clone(
    Document context
    )
  {throw new NotImplementedException();}

  /**
    Gets the annotation's down appearance.
  */
  public AppearanceStates getDown(
    )
  {
    /*
      NOTE: 'D' entry may be undefined;
      nonetheless, since it always has a default value, it is always exposed.
    */
    return new AppearanceStates(
      PdfName.D,
      getContainer(),//TODO:verify container/baseobject/this
      this
      );
  }

  /**
    Gets the annotation's normal appearance.
  */
  public AppearanceStates getNormal(
    )
  {
    /*
      NOTE: 'N' entry is required.
    */
    return new AppearanceStates(
      PdfName.N,
      getContainer(),//TODO:verify container/baseobject/this
      this
      );
  }

  /**
    Gets the annotation's rollover appearance.
  */
  public AppearanceStates getRollover(
    )
  {
    /*
      NOTE: 'R' entry may be undefined;
      nonetheless, since it always has a default value, it is always exposed.
    */
    return new AppearanceStates(
      PdfName.R,
      getContainer(),//TODO:verify container/baseobject/this
      this
      );
  }
  // </public>
  // </interface>
  // </dynamic>
  // </class>
}