<?php

namespace AppBundle\Controller;

use AppBundle\Entity\Report;
use AppBundle\Form\ReportType;
use Sensio\Bundle\FrameworkExtraBundle\Configuration\Route;
use Symfony\Bundle\FrameworkBundle\Controller\Controller;
use Symfony\Component\HttpFoundation\Request;

class ReportController extends Controller
{
    /**
     * @param Request $request
     * @Route("/", name="index")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function index(Request $request)
    {
        $taskRepository = $this->getDoctrine()->getRepository(Report::class);

        $reports = $taskRepository->findAll();

        return $this->render('report/index.html.twig', ['reports' => $reports]);

//        $taskRepository = $this->getDoctrine()->getRepository(Report::class);
//
//        $normalTasks = $taskRepository->findBy(["status" => "Normal"]);
//        $warningTasks = $taskRepository->findBy(["status" => "Warning"]);
//        $criticalTasks = $taskRepository->findBy(["status" => "Critical"]);
//
//        return $this->render('report/index.html.twig',
//            ['normalTasks' => $normalTasks,
//                'warningTasks' => $warningTasks,
//                'criticalTasks' => $criticalTasks]);

    }

    /**
     * @Route("/details/{id}", name="details")
     *
     * @param $id
     * @param Request $request
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function details($id, Request $request)
    {
        $taskRepository = $this->getDoctrine()->getRepository(Report::class);

        $report = $taskRepository->find($id);

        $form = $this->createForm(ReportType::class, $report);

        return $this->render('report/details.html.twig', ['report' => $report, 'form' => $form->createView()]);

    }

    /**
     * @param Request $request
     * @Route("/create", name="create")
     * @return \Symfony\Component\HttpFoundation\Response
     */
    public function create(Request $request)
    {
        $report = new Report();

        $form = $this->createForm(ReportType::class, $report);

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid())
        {

            if ($report->getStatus() == null || $report->getMessage() == null || $report->getOrigin() == null){
                return $this->redirectToRoute('create');
            }

            $em = $this->getDoctrine()->getManager();

            $em->persist($report);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('report/create.html.twig', ['form' => $form->createView()]);

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
        $taskRepository = $this->getDoctrine()->getRepository(Report::class);

        $report = $taskRepository->find($id);

        if ($report == null)
        {
            return $this->redirectToRoute('index');
        }

        $form = $this->createForm(ReportType::class, $report);

        $form->handleRequest($request);

        if ($form->isSubmitted() && $form->isValid())
        {
            $em = $this->getDoctrine()->getManager();
            $em->remove($report);
            $em->flush();

            return $this->redirectToRoute('index');
        }

        return $this->render('report/delete.html.twig', ['report' => $report, 'form' => $form->createView()]);

    }
}
