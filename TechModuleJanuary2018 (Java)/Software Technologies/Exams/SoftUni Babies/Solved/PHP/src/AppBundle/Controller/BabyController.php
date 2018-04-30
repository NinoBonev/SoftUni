<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Baby;
use AppBundle\Form\BabyType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class BabyController extends Controller
{
    /**
     * @param Request $request
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index(Request $request)
    {
        $babyRepository = $this->getDoctrine()->getRepository(Baby::class);

        $babies = $babyRepository->findAll();

        return $this->render('baby/index.html.twig', ['babies' => $babies]);
    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        $baby = new Baby();

        $form = $this->createForm(BabyType::class, $baby);

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid())
        {

            if ($baby->getName() == null || $baby->getGender() == null || $baby->getBirthday() == null){
                return $this->redirectToRoute('create');
            }

            $em = $this->getDoctrine()->getManager();

            $em->persist($baby);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('baby/create.html.twig', ['form' => $form->createView()]);
    }

    /**
     * @Route("/edit/{id}", name="edit")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function edit($id, Request $request)
    {
        $babyRepository = $this->getDoctrine()->getRepository(Baby::class);
        $baby = $babyRepository->find($id);

        $form = $this->createForm(BabyType::class, $baby);
        $form->handleRequest($request);
        if ($form->isSubmitted() && $form->isValid()) {

            if ($baby->getName() == null || $baby->getGender() == null || $baby->getBirthday() == null){
                return $this->redirect("/");
            }

            $em = $this->getDoctrine()->getManager();
            $em->merge($baby);
            $em->flush();
            return $this->redirect("/");
        }
        return $this->render(
            "baby/edit.html.twig",
            ["baby" => $baby, "form" => $form->createView()]
        );
    }

    /**
     * @Route("/delete/{id}", name="delete")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function delete($id, Request $request)
    {
        $babyRepository = $this->getDoctrine()->getRepository(Baby::class);

        $baby = $babyRepository->find($id);

        if ($baby == null)
        {
            return $this->redirectToRoute('index');
        }

        $form = $this->createForm(BabyType::class, $baby);

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid())
        {
            $em = $this->getDoctrine()->getManager();
            $em->remove($baby);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('baby/delete.html.twig', ['baby' => $baby, 'form' => $form->createView()]);
    }
}
